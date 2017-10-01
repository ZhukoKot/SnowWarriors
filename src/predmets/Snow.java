package predmets;

import javax.swing.*;
import java.awt.*;

/**
 * Класс реализует снежок, которым будет кидать
 * главный игрок и враги
 * @author Балун Владимир
 */
public class Snow {

    /**
     * Переменные класса описывающие позицию снежка
     * @variable positionX - позиция снежка по оси Х
     * @variable positionY - позиция снежка по оси Y
     */
    private int positionX;
    private int positionY;
    private Image image;

    /**
     * Конструктор класса задающий координаты снежку
     * @param X - задание координаты по оси Х
     * @param Y - задание координаты по оси Y
     * @param imagePath -
     */
    public Snow(int X, int Y, String imagePath) {
        this.positionX = positionX;
        this.positionY = positionY;

        image = new ImageIcon(imagePath).getImage();
    }

    /**
     * Getters и Setters задающие и возвращающие картинку, а
     * также значения координат по оси Х и по оси Y
     */
    public int getPositionX() {
        return positionX;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
}
