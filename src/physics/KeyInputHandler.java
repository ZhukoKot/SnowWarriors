package physics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Класс реализующий обработчики событий по нажатим
 * на клавиши LEFT и RIGHT
 * @author Балун Владимир
 */
public class KeyInputHandler extends KeyAdapter{

    /**
     * Флаги обозначающие была ли нажата кнопка на клавиатуре
     * @variable leftPressed - клавиша LEFT
     * @variable rightPressed - клавиша RIGHT
     * @variable upPressed - клавиша UP
     */
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean upPressed;
    private boolean spacePressed;

    /**
     * Конструктор класса, инициализируем флаги, в ненажатое
     * состояние
     */
    public KeyInputHandler() {
        this.leftPressed = false;
        this.rightPressed = false;
        this.upPressed = false;
        this.spacePressed = false;
    }

    /**
     * Обработчик события по нажатию на кнопку
     * @param e - событие нажатия кнопки
     */
    public void keyPressed(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            spacePressed = true;
        }

    }

    /**
     * Обработчик события по отжатию кнопки
     * @param e - событие нажатия кнопки
     */
    public void keyReleased(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            spacePressed = false;
        }

    }

    /**
     * Getter's возвращающие флаги кнопок
     */
    public boolean isLeftPressed() {
        return leftPressed;
    }
    public boolean isRightPressed() {
        return rightPressed;
    }
    public boolean isUpPressed() {
        return upPressed;
    }
    public boolean isSpacePressed() {
        return spacePressed;
    }

}
