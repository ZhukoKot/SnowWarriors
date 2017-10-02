package persons;

import javax.swing.*;
import java.awt.*;

/**
 * Класс реализует интерфейс Person, а именно реализовывает
 * перемещение противника, стрельбу, задает здоровье, мощь и
 * устанавливает количество собранных им предметов
 * @author Жуков Юрий
 */

public class Enemy extends Person {

    /**
     * @variable image - изображение противника
     */
    private Image image;
    /**
     * Конструктор задающий первоначальные данные об игроке, а
     * именно его здоровье, мощь и количество собранных предметов,
     * путь к его картинке
     * @param health - здоровье противника
     * @param power - мощь игрока
     * @param imagePath - путь к картинке игрока
     * @param X - позиция игрока по X
     * @param Y - позиция игрока по Y
     * @throw IOException - обрабатываем исключение, на случай не правильного пути картинки
     */
    public Enemy (int health, int power, String imagePath, int X, int Y){
        super(health, power, X, Y);
        this.image = new ImageIcon(imagePath).getImage();
    }
    /**
     * Getters and Setters  возвращающие и
     * устанавливающие картинку противника
     */
    public Image getImage(){
        return image;
    }
    public void setImage(String imagePath){
        this.image = new ImageIcon(imagePath).getImage();
    }
    /**
     * Переопределение метода абстрактного класса Person о
     * отрисовки противника в окне приложения
     * @param graphic - задаем канвас на котором будет происходить отрисовка
     */
    @Override
    public void draw(Graphics graphic){
        //рендерим изображение
        graphic.drawImage(image, getPositionX(), getPositionY(),null);
    }

    @Override
    public void move() {

    }

    /**
     * Переопределение метода абстрактного класса Person по
     * стерльбе противника
     */
    @Override
    public void shoot() {

    }
}
