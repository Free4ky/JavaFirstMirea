package ru.mirea.task16.GAME;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    // ПОЛЯ
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private Thread thread;
    private boolean running;

    private BufferedImage image; // холст
    private Graphics2D g; // кисть

    private int FPS = 30; // отвечает за ограничение кадров в секунду
    private double averageFPS;

    public static Player player;

    public static ArrayList<Bullet> bullets; // массив пуль
    public static ArrayList<Enemy> enemies; // массив врагов
    public static ArrayList<PowerUp> powerUps; //массив припасов-улучшений
    public static ArrayList<Explosion> explosions;
    public static ArrayList<Text> texts;

    private long waveStartTimer;
    private long waveStartTimerDiff; // показывает сколько времени прошло
    private int waveNumber; // отвечает за номер волны
    private boolean waveStart; // показвает началась ли волна
    private int waveDelay = 2000;

    private static int frameCount;

    private BufferedImage health_icon;

    private BufferedImage background;

    private long slowDownTimer; // таймер замедления времени
    private long slowDownTimerDiff;
    private int slowDownLength = 6000; // время замедления

    // КОНСТРУКТОР
    public GamePanel(){
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true); // позволяет фокусироваться на объекте GamePa nel
        requestFocus(); // получает фокус
    }

    //ФУНКЦИИ
    public void addNotify() { // сообщает компоненту GamePanel, что у него есть родитель JPanel
        super.addNotify();
        if (thread == null){
            thread = new Thread(this); // начало игры. передаем в поток текуищй объект GamePanel
            thread.start();
        }
        addKeyListener(this); // добавление пользовательского ввода
    }
    public void run(){
        running = true;
        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB); // инициализация холста
        g = (Graphics2D) image.getGraphics(); // инициализация кисти для холста
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // улучшение графики
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON); // улучшение графики

        player = new Player(); // создание игрока

        bullets = new ArrayList<Bullet>(); // инициализация листа пуль

        enemies = new ArrayList<Enemy>(); // инициализация листа врагов

        powerUps = new ArrayList<PowerUp>(); // инициализация листа улучшений

        explosions = new ArrayList<Explosion>(); // инициализация листа взрывов

        texts = new ArrayList<Text>();

        waveStartTimer = 0;
        waveStartTimerDiff = 0;
        waveStart = true;
        waveNumber = 0;

        long startTime;
        long URDTimeMillis;
        long waitTime;
        long totalTime = 0;

        frameCount = 0;
        int maxFrameCount = 30;

        long targetTime = 1000/FPS; // количество миллисекнуд на один круг программы
        while (running){
            startTime = System.nanoTime();

            gameUpdate();
            gameRender();
            gameDraw();

            URDTimeMillis = (System.nanoTime() - startTime) / 1000000;

            waitTime = targetTime - URDTimeMillis; // время ожидания следующего круга. Чтобы каждый круг длился одинаковое количество времени

            try { // ограничение скорости работы игры
                Thread.sleep(waitTime);
            }catch (Exception e) {
            }

            totalTime += System.nanoTime() - startTime; // сумма всех кругов по времени
            frameCount++;
            if (frameCount == maxFrameCount){ // подсчет среднего FPS
                averageFPS = 1000.0/ ((totalTime / frameCount)/ 1000000);
                frameCount = 0;
                totalTime = 0;
            }
        }
        g.setColor(new Color(0,170,255));
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Century Gothic",Font.PLAIN,16));
        String s = "G A M E   O V E R";
        int length = (int) g.getFontMetrics().getStringBounds(s,g).getWidth();
        g.drawString(s,WIDTH/2 - length/2, HEIGHT/2);
        s = "Total score: " + player.getScore();
        length = (int) g.getFontMetrics().getStringBounds(s,g).getWidth();
        g.drawString(s,WIDTH/2 - length/2, HEIGHT/2 + 30);
        gameDraw();

    }
    public static int getFrameCount(){return frameCount;}
    private void gameUpdate(){ // обновление игры (позиции игрока, позиции врага, позиции снарядов, столкновений и т.д)

        //Новая волна
        if (waveStartTimer == 0 && enemies.size() == 0){ // все враги вне экрана и
            waveNumber++;
            waveStart = false; // пока не создаем врагов
            waveStartTimer = System.nanoTime();
        }
        else{
            waveStartTimerDiff = (System.nanoTime() - waveStartTimer)/1000000; // сколько времени прошло
            if (waveStartTimerDiff > waveDelay){
                waveStart = true;
                waveStartTimer = 0;
                waveStartTimerDiff = 0;
            }
        }

        // создание врагов
        if (waveStart && enemies.size() == 0){ // если началась волна
            createNewEnemies();
        }

        // обновление информации об игроке
        player.update();

        // обновление пуль
        for (int i = 0; i < bullets.size(); i++){ // обновление информации о пулях
            boolean remove = bullets.get(i).update();
            if (remove){
                bullets.remove(i); // удаление пули, если она вышла за границы экрана
                i--;
            }
        }
        //обновление врагов
        for (int i = 0; i < enemies.size(); i++){
            enemies.get(i).update();
        }

        // обновление припасов-усилителей
        for (int i = 0; i < powerUps.size(); i++){
            boolean remove = powerUps.get(i).update();
            if (remove){
                powerUps.remove(i);
                i--;
            }
        }

        // Обновление взрывов
        for (int i = 0; i < explosions.size(); i++){
            boolean remove = explosions.get(i).update();
            if (remove){
                explosions.remove(i);
                i--;
            }
        }

        //Обновление текстов
        for (int i = 0; i < texts.size(); i++){
            boolean remove = texts.get(i).update();
            if (remove){
                texts.remove(i);
                i--;
            }
        }

        // коллизия пули и врага
        for (int i = 0; i < bullets.size(); i++){
            Bullet b = bullets.get(i);
            double bx = b.getX();
            double by = b.getY();
            double br = b.getR();
            for (int j = 0; j < enemies.size(); j++){
                Enemy e = enemies.get(j);
                double ex = e.getX();
                double ey = e.getY();
                double er = e.getR();


                double dx = bx - ex; // разница координат по x
                double dy = by - ey; // разница координат по y
                double dist = Math.sqrt(dx*dx + dy*dy);

                if (dist < br+er){ // если расстояние меньше суммы радиусов пули и врага
                    e.hit();
                    bullets.remove(i); // удаление пули, которая попала во врага
                    i--;
                    break;
                }
            }
        }

        // проверка мертвых врагов
        for (int i = 0; i < enemies.size(); i++){
            if (enemies.get(i).isDead()){

                Enemy e = enemies.get(i);

                // выпадение припаса-улучшения при смерти врага с каким-то шансом

                // шанс выпадения
                double rand = Math.random(); // случайное число от 0 до 1
                if (rand < 0.01) {
                    powerUps.add(new PowerUp(power_type.addExtraLife,e.getX(),e.getY()));
                }
                else if (rand < 0.020) {
                    powerUps.add(new PowerUp(power_type.addTwoPower,e.getX(),e.getY()));
                }
                else if (rand < 0.120){
                    powerUps.add(new PowerUp(power_type.addOnePower,e.getX(),e.getY()));
                }
                else if (rand < 0.130){
                    powerUps.add(new PowerUp(power_type.slowTime,e.getX(),e.getY()));
                }
                else {
                    powerUps.add(new PowerUp(power_type.addTwoPower,e.getX(),e.getY()));
                }
                if (e.getType() == type.type_first){
                    if (e.getRank() == rank.rank_first){ // сколько очков за врага первого типа первого ранга
                        player.addScore(100);
                    }
                    else if (e.getRank() == rank.rank_second){
                        player.addScore(200);
                    }
                    else if (e.getRank() == rank.rank_third){
                        player.addScore(300);
                    }
                    else if (e.getRank() == rank.rank_fourth){
                        player.addScore(400);
                    }
                }
                else if (e.getType() == type.type_second){
                    if (e.getRank() == rank.rank_first){
                        player.addScore(500);
                    }
                    else if (e.getRank() == rank.rank_second){
                        player.addScore(800);
                    }
                }
                enemies.remove(i);
                i--;
                e.explode();
                explosions.add(new Explosion(e.getX(),e.getY() + e.getR()/2,e.getR(),e.getR()+30));
            }
        }

        // Проверка на мертвого игрока

        if (player.isDead()){
            running = false;
        }
        // коллизия врага и игрока
        if (!player.isRecovering()){ // если игрок не восстанавливается
            int px = player.getX();
            int py = player.getY();
            int pw = player.getIcon_width();
            int ph = player.getIcon_height();
            py = py + ph/2; // решение проблемы хитбокса игрока
            for (int i = 0; i < enemies.size(); i++){
                Enemy e = enemies.get(i);
                double ex = e.getX();
                double ey = e.getY();
                double er = e.getR();

                double dx = ex-px;
                double dy = ey-py;
                double diagonal = Math.sqrt(pw*pw + ph*ph)/2;
                diagonal = diagonal - diagonal/3;
                double dist = Math.sqrt(dx*dx + dy*dy);
                if (dist <= diagonal + er){
                    player.loseLife();
                }
            }
        }

        // коллизия игрока и припаса
        int px = player.getX();
        int py = player.getY();
        int pw = player.getIcon_width();
        int ph = player.getIcon_height();
        py = py + ph/2;
        double diagonal = Math.sqrt(pw*pw + ph*ph)/2;
        diagonal = diagonal - diagonal/2;
        for (int i = 0; i < powerUps.size(); i++){
            PowerUp pu = powerUps.get(i);
            double puX = pu.getX();
            double puY = pu.getY();
            int puR = pu.getR();
            double dx = px - puX;
            double dy = py - puY;
            double dist = Math.sqrt(dx*dx + dy*dy);

            // Игрок собирает припас
            if (dist <= diagonal + puR){
                powerUps.remove(i);
                i--;
                power_type pt = pu.getPowerType();
                switch (pt){
                    case addExtraLife:
                        player.gainLife();
                        texts.add(new Text(player.getX(), player.getY(),2000,"Extra life"));
                        break;
                    case addOnePower:
                        player.increasePower(1);
                        texts.add(new Text(player.getX(), player.getY(),2000,"Power Up"));
                        break;
                    case addTwoPower:
                        player.increasePower(2);
                        texts.add(new Text(player.getX(), player.getY(),2000,"Double Power Up"));
                        break;
                    case slowTime:
                        slowDownTimer = System.nanoTime();
                        for (int j = 0; j < enemies.size(); j++){
                            enemies.get(j).setSlow(true);
                        }
                        texts.add(new Text(player.getX(), player.getY(),2000,"Slow down"));
                        break;
                }

            }

        }
        // обновление замедляения времени
        if (slowDownTimer != 0){
            slowDownTimerDiff = (System.nanoTime() - slowDownTimer)/1000000;
            if (slowDownTimerDiff > slowDownLength){ // срок действия замедления кончился
                slowDownTimer = 0;
                for (int j = 0; j < enemies.size(); j++){ // проходимся по всем врагам, чтобы установить изначальную скорость
                    enemies.get(j).setSlow(false);
                }
            }
        }
    }

    private void gameRender(){ // отрисовывает все компоненты игры(игрока врагов снаряды задний фон и т.д)

        // Отрисовка заднего фона
        g.setColor(new Color(0,170,255));
        g.fillRect(0,0,WIDTH,HEIGHT); // заполняет экран
        if (slowDownTimer != 0){
            g.setColor(new Color(255,255,255,64));
            g.fillRect(0,0,WIDTH,HEIGHT);
        }
        BufferedImage buf;
        //try{
            //buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\background.PNG"));
            //background = resize(buf,WIDTH,HEIGHT);
        //}catch(Exception e){}
        //g.drawImage(background,0,0,null);
        g.setColor(Color.BLACK);
        g.drawString("FPS: " + averageFPS,10,10);
        g.drawString("Num bullets" + bullets.size(), 10,20);


        // отрисовка игрока
        player.draw(g);
        // отрисовка пуль
        for (int i = 0; i < bullets.size(); i++){ // отрисовка пуль
            bullets.get(i).draw(g);
        }
        // отрисовка врагов
        for (int i = 0; i < enemies.size(); i++){
            enemies.get(i).draw(g);
        }

        // отрисовка припасов-усилителей
        for (int i = 0; i < powerUps.size(); i++){
            powerUps.get(i).draw(g);
        }

        // отрисовка взрывов
        for (int i = 0; i < explosions.size(); i++){
            explosions.get(i).draw(g);
        }

        // отрисовка текстов
        for (int i = 0; i < texts.size(); i++){
            texts.get(i).draw(g);
        }

        // отрисовка номера волны
        if (waveStartTimer != 0){ // если волна в процессе
            g.setFont(new Font("Century Gothic",Font.PLAIN,18));
            String s = "- W A V E  " + waveNumber + "  -";
            int length = (int) g.getFontMetrics().getStringBounds(s,g).getWidth(); // длина строки в пикселях
            int alpha = (int) (255*Math.sin(3.14*waveStartTimerDiff / waveDelay)); // прозрачность
            if (alpha > 255) {
                alpha = 255;
            }
            g.setColor(new Color(255,255,255,alpha)); // цвет с прозрачностью alpha
            g.drawString(s,WIDTH/2 - length/2,HEIGHT/2); // отрисовка строки волны по середине
            g.setFont(new Font("Century Gothic",Font.PLAIN,10));
        }

        // отрисовка health points игрока
        try{
            buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\player_health.png"));
            health_icon = resize(buf,15,15);
        }
        catch(Exception e){}
        for (int i = 0; i < player.getLives(); i++){
            g.drawImage(health_icon,(int)(10+i*20),30, null);
        }

        // Отрисовка уровня игрока

        g.setColor(Color.YELLOW);
        if (player.getPowerLevel() == player.getMaxPowerLevel()){
            g.fillRect(10,50, player.getPower()*8,8);
            g.setColor(Color.WHITE);
            String s = "Max Power!";
            g.setFont(new Font("Century Gothic", Font.PLAIN,10));
            g.drawString(s, 10+player.getRequiredPower()*9, 60);
        }
        else{
            g.fillRect(10,50, player.getPower()*8,8);
        }
        g.setColor(Color.YELLOW.darker());
        g.setStroke(new BasicStroke(2));
        for (int i = 0; i < player.getRequiredPower(); i++){
            g.drawRect(10 + i*8,50,8,8);
        }
        g.setStroke(new BasicStroke(1));

        //отрисовка шкалы замедления времени

        if (slowDownTimer != 0){ // если подобран припас замедления времени
            g.setColor(Color.WHITE);
            g.drawRect(10,65,100,8);
            g.fillRect(10,65,(int)(100 - 100*slowDownTimerDiff/slowDownLength),8);
        }

        //отрисовка счета игрока
        g.setColor(Color.WHITE);
        g.setFont(new Font("Century Gothic", Font.PLAIN,14));
        g.drawString("Score: "+player.getScore(),WIDTH - 100,30);
        g.setFont(new Font("Century Gothic",Font.PLAIN,10));

    }
    private void gameDraw(){ // отрисовка закадрового изображения. Объект g связан с закадровым изображением
        Graphics g2  = this.getGraphics();// графический объект для GamePanel. Это кисть для ирового экрана
        g2.drawImage(image,0,0,null); // отрисовка закадрового изображения
        g2.dispose(); // освобождает ресурсы объекта g2/Избавляется от этого графического контекста и выпускает любые системные ресурсы, которые он использует.
    }
    // два графических объекта используются для уменьшения мерцания итоговой картинки. Сначала g отрисовывает всё в буфферное изображение, а потом g2 отрисовывает буфферную картинку на экран.
    // double buffering

    //Метод создания новых врагов
    public void createNewEnemies(){

        enemies.clear();
        Enemy e;
        if (waveNumber == 1){
            for (int i = 0; i < 4; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_first)); // если номер волны = 1, создается 4 врага первого типа 1 ранга
            }
            for (int i = 0; i < 1; i++){
                enemies.add(new Enemy(type.type_fourth, rank.rank_first)); // если номер волны = 1, создается 4 врага первого типа 1 ранга
            }
            for (int i = 0; i < 3; i++){
                enemies.add(new Enemy(type.type_third, rank.rank_first)); // если номер волны = 1, создается 4 врага первого типа 1 ранга
            }
        }
        if (waveNumber == 2){
            for (int i = 0; i < 8; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_first)); // если номер волны = 1, создается 8 врагов первого типа 1 ранга
            }
        }
        if (waveNumber == 3){
            for (int i = 0; i < 4; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_first)); // если номер волны = 3, создается 4 врага первого типа 1 ранга
            }
            for (int i = 0; i < 4; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_second)); // если номер волны = 3, создается 4 врага первого типа 2 ранга
            }
        }
        if (waveNumber == 4){
            for (int i = 0; i < 8; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_first)); // если номер волны = 3, создается 4 врага первого типа 1 ранга
            }
            for (int i = 0; i < 8; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_second)); // если номер волны = 3, создается 4 врага первого типа 2 ранга
            }
        }
        if (waveNumber == 5){
            for (int i = 0; i < 8; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_second)); // если номер волны = 3, создается 4 врага первого типа 2 ранга
            }
            for (int i = 0; i < 3; i++){
                enemies.add(new Enemy(type.type_second, rank.rank_first)); // если номер волны = 3, создается 4 врага первого типа 1 ранга
            }
        }
        if (waveNumber == 6){
            for (int i = 0; i < 10; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_first)); // если номер волны = 3, создается 4 врага первого типа 2 ранга
            }
            for (int i = 0; i < 5; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_second)); // если номер волны = 3, создается 4 врага первого типа 1 ранга
            }
            for (int i = 0; i < 2; i++){
                enemies.add(new Enemy(type.type_second, rank.rank_first)); // если номер волны = 3, создается 4 врага первого типа 2 ранга
            }
            for (int i = 0; i < 1; i++){
                enemies.add(new Enemy(type.type_second, rank.rank_second)); // если номер волны = 3, создается 4 врага первого типа 1 ранга
            }
        }
        if (waveNumber == 7){
            for (int i = 0; i < 4; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_second)); // если номер волны = 3, создается 4 врага первого типа 2 ранга
            }
            for (int i = 0; i < 3; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_third)); // если номер волны = 3, создается 4 врага первого типа 1 ранга
            }
            for (int i = 0; i < 1; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_fourth)); // если номер волны = 3, создается 4 врага первого типа 2 ранга
            }
            for (int i = 0; i < 7; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_first)); // если номер волны = 3, создается 4 врага первого типа 1 ранга
            }

        }
        if (waveNumber == 8){
            for (int i = 0; i < 6; i++){
                enemies.add(new Enemy(type.type_second, rank.rank_first)); // если номер волны = 3, создается 4 врага первого типа 2 ранга
            }
            for (int i = 0; i < 3; i++){
                enemies.add(new Enemy(type.type_second, rank.rank_second)); // если номер волны = 3, создается 4 врага первого типа 2 ранга
            }
            for (int i = 0; i < 4; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_third)); // если номер волны = 3, создается 4 врага первого типа 2 ранга
            }
        }
        if (waveNumber == 9){
            running = false;
        }
    }
    public void keyTyped(KeyEvent key){
    }
    public void keyPressed(KeyEvent key){ // обработка зажатой клавиши
        int keyCode = key.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT){
            player.setLeft(true);
        }
        if (keyCode == KeyEvent.VK_RIGHT){
            player.setRight(true);
        }
        if (keyCode == KeyEvent.VK_UP){
            player.setUP(true);
        }
        if (keyCode == KeyEvent.VK_DOWN){
            player.setDown(true);
        }
        if (keyCode == KeyEvent.VK_Z){
            player.setFiring(true);
        }
    }
    public void keyReleased(KeyEvent key){ // обработка отпускания клавиши
        int keyCode = key.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT){
            player.setLeft(false);
        }
        if (keyCode == KeyEvent.VK_RIGHT){
            player.setRight(false);
        }
        if (keyCode == KeyEvent.VK_UP){
            player.setUP(false);
        }
        if (keyCode == KeyEvent.VK_DOWN){
            player.setDown(false);
        }
        if (keyCode == KeyEvent.VK_Z){
            player.setFiring(false);
        }
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
