package ui;

import persons.Player;
import physics.KeyInputHandler;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Класс реализующий основную сцену игры, здесь реализован основной цикл игры,
 * также система рендеринга, инициализации и обновления
 * @author Балун Владимир
 */
public class Scene extends Canvas implements Runnable{

    /**
     * Переменные класса
     * @variable isRunning - передает значение циклу запущена ли игра в данный момент
     * @variable player - создаем основного игрока игры
     * @variable handler - обработчки событий по нажатию на кнопки
     */
    private boolean isRunning;
    private static Player player;
    private KeyInputHandler handler;
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
        player = new Player(100,10,0, "src/res/person.png",30,500);
        handler = new KeyInputHandler();

        //Добавляем слушателя событий по нажатию на кнопку
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
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0, getWidth(), getHeight());
        player.draw(graphics);
        graphics.dispose();
        bufferStrategy.show();

    }

    /**
     * Метод выполняющий изменение объектов во время игрового цикла
     * @param delta - время изменений
     */
    public void update(long delta){

        if(handler.isLeftPressed()){
            player.setPositionX(player.getPositionX() - 1);
        }

        if(handler.isRightPressed()){
            player.setPositionX(player.getPositionX() + 1);
        }

    }

}
