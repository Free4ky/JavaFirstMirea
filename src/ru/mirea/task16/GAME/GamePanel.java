package ru.mirea.task16.GAME;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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

    // КОНСТРУКТОР
    public GamePanel(){
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true); // позволяет фокусироваться на объекте GamePanel
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

        player = new Player();

        bullets = new ArrayList<Bullet>();
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
        player.update(); // обновление информации об игроке
        for (int i = 0; i < bullets.size(); i++){ // обновление информации о пулях
            boolean remove = bullets.get(i).update();
            if (remove){
                bullets.remove(i); // удаление пули, если она вышла за границы экрана
                i--;
            }
        }
    }
    private void gameRender(){ // отрисовывает все компоненты игры(игрока врагов снаряды задний фон и т.д)
        g.setColor(new Color(0,170,255));
        g.fillRect(0,0,WIDTH,HEIGHT); // заполняет экран
        g.setColor(Color.BLACK);
        g.drawString("FPS: " + averageFPS,10,10);
        g.drawString("Num bullets" + bullets.size(), 10,20);
        player.draw(g); // отрисовка игрока
        for (int i = 0; i < bullets.size(); i++){ // отрисовка пуль
            bullets.get(i).draw(g);
        }
    }
    private void gameDraw(){ // отрисовка закадрового изображения. Объект g связан с закадровым изображением
        Graphics g2  = this.getGraphics();// графический объект для GamePanel. Это кисть для ирового экрана
        g2.drawImage(image,0,0,null); // отрисовка закадрового изображения
        g2.dispose(); // освобождает ресурсы объекта g2/Избавляется от этого графического контекста и выпускает любые системные ресурсы, которые он использует.
    }
    // два графических объекта используются для уменьшения мерцания итоговой картинки. Сначала g отрисовывает всё в буфферное изображение, а потом g2 отрисовывает буфферную картинку на экран.
    // double buffering

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

}
