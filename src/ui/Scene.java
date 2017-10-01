package ui;

import persons.Player;
import physics.KeyInputHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Класс реализующий основную сцену игры, здесь реализован основной цикл игры,
 * также система рендеринга, инициализации и обновления
 * @author Балун Владимир
 */
public class Scene extends Canvas implements Runnable{

    /**
     * Параметры сцены
     * @variable WIDTH - ширина сцены
     * @variable HEIGHT - высота сцены
     */
    private final int WIDTH;
    private final int HEIGHT;

    /**
     * Конструкто, задающий размеры сцены
     * @param WIDTH - ширина сцены
     * @param HEIGHT - высота сцены
     */
    public Scene(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    /**
     * Переменные класса
     * @variable isRunning - передает значение циклу запущена ли игра в данный момент
     * @variable player - создаем основного игрока игры
     * @variable handler - обработчки событий по нажатию на кнопки
     * @variable backgroundImg - фоновая картинка игры
     * @variable countGiftsImg - картикка количества собранных подарков
     */
    private boolean isRunning;
    private static Player player;
    private KeyInputHandler handler;
    Image backgroundImg;
    Image countGiftsImg;
    /**
     * Запускаем выполнение потока, и присвамваем значение @variable isRunning
     * в запущенное состояние игры
     */
    public void start(){
        isRunning = true;
        new Thread(this).start();
    }

    /**
     * Создаем основной поток и игровой цикл игры
     */
    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        long delta;

        init();

        //основной цикл игры
        while(isRunning) {
            delta = System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            render();
            update(delta);
        }
    }

    /**
     * Инициализация основных компонентов игры
     */
    public void init(){
        player = new Player(3,10,0, "src/res/person.png",30,500);
        backgroundImg = new ImageIcon("src/res/background.jpg").getImage();
        countGiftsImg = new ImageIcon("src/res/count_gifts.png").getImage();

        //Добавляем слушателя событий по нажатию на кнопку
        handler = new KeyInputHandler();
        addKeyListener(handler);
    }

    /**
     * Отрисовка игры, здесь задаем 3-ую буфферизацию, и выводим
     * все изображение в окно приложения
     */
    public void render(){

        //Задаем тройную буфферизацию
        BufferStrategy bufferStrategy = getBufferStrategy();
        if(bufferStrategy == null){
            createBufferStrategy(3);
            requestFocus();
            return;
        }

        // устанавливаем канвас, задаем цвет фону, и ренедерим игрока
        Graphics graphics = bufferStrategy.getDrawGraphics(); //

        //Отрисовываем все компоненты
        graphics.fillRect(0,0, WIDTH, HEIGHT);
        graphics.drawImage(backgroundImg,0,0,null);
        graphics.drawString("0",900,50);
        graphics.drawImage(countGiftsImg,920,10,65,65,null);

        player.draw(graphics);
        graphics.dispose();
        bufferStrategy.show();

    }

    /**
     * Метод выполняющий изменение объектов во время игрового цикла
     * @param delta - время изменений
     */
    public void update(long delta){

        if(handler.isLeftPressed() && player.getPositionX() > 0){
            player.setPositionX(player.getPositionX() - 1 * (int)delta);
        }

        if(handler.isRightPressed() && player.getPositionX() < WIDTH - 30){
            player.setPositionX(player.getPositionX() + 1 * (int)delta);
        }

        if(handler.isUpPressed()){
            player.setPositionY(player.getPositionY() - 1 * (int)delta);
            player.setPositionY(player.getPositionY() + 1 * (int)delta);
        }

    }

}
