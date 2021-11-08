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

    private long waveStartTimer;
    private long waveStartTimerDiff; // показывает сколько времени прошло
    private int waveNumber; // отвечает за номер волны
    private boolean waveStart; // показвает началась ли волна
    private int waveDelay = 2000;

    private BufferedImage health_icon;

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

        waveStartTimer = 0;
        waveStartTimerDiff = 0;
        waveStart = true;
        waveNumber = 0;

        long startTime;
        long URDTimeMillis;
        long waitTime;
        long totalTime = 0;

        int frameCount = 0;
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

    }
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
                enemies.remove(i);
                i--;
            }
        }
    }

    private void gameRender(){ // отрисовывает все компоненты игры(игрока врагов снаряды задний фон и т.д)

        // Отрисовка заднего фона
        g.setColor(new Color(0,170,255));
        g.fillRect(0,0,WIDTH,HEIGHT); // заполняет экран
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

        // отрисовка номера волны
        if (waveStartTimer != 0){ // если волна в процессе
            g.setFont(new Font("Century Gothic",Font.PLAIN,18));
            String s = "- W A W E  " + waveNumber + "  -";
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
            BufferedImage buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\player_health.png"));
            health_icon = resize(buf,15,15);
        }
        catch(Exception e){}
        for (int i = 0; i < player.getLives(); i++){
            g.drawImage(health_icon,(int)(10+i*20),30, null);
        }
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
        }
        if (waveNumber == 2){
            for (int i = 0; i < 8; i++){
                enemies.add(new Enemy(type.type_first, rank.rank_first)); // если номер волны = 1, создается 8 врагов первого типа 1 ранга
            }
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
