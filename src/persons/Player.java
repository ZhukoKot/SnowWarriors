package persons;

import javax.swing.*;
import java.awt.*;

/**
 * Класс реализует интерфейс Person, а именно реализовывает
 * перемещение игрока, стрельбу, задает здоровье, мощь и
 * устанавливает количество собранных им предметов
 * @author Балун Владимир
 */
public class Player extends Person {

    /**
     * @variable coins - количество собранных предметов игроком
     * @variable image - изображение игрока
     */
    private int coins;
    private Image image;

    /**
     * Конструктор задающий первоначальные данные об игроке, а
     * именно его здоровье, мощь и количество собранных предметов,
     * путь к его картинке
     * @param health - здоровье игрока
     * @param potency - мощь игрока
     * @param coins - количество собранных предметов игрока
     * @param imagePath - путь к картинке игрока
     * @param X - позиция игрока по X
     * @param Y - позиция игрока по Y
     * @throw IOException - обрабатываем исключение, на случай не правильного пути картинки
     */
    public Player(int health, int potency, int coins, String imagePath, int X, int Y){
        super(health, potency, X, Y);
        this.image = new ImageIcon(imagePath).getImage();
    }

    /**
     * Getters and Setters возвращающие и устанавливающие
     * количество собранных предметов, также возвращающие и
     * устанавливающие картинку игрока
     */
    public int getCoins(){
        return coins;
    }
    public void setCoins(int value){
        this.coins = value;
    }
    public Image getImage(){
        return image;
    }
    public void setImage(String imagePath){
        this.image = new ImageIcon(imagePath).getImage();
    }

    /**
     * Переопределение метода абстрактного класса Person о
     * отрисовки игрока в окне приложения
     * @param graphic - задаем канвас на котором будет происходить отрисовка
     */
    @Override
    public void draw(Graphics graphic){
        //рендерим изображение
        graphic.drawImage(image, getPositionX(), getPositionY(),null);
    }

    /**
     * Переопределение метода абстрактного класса Person по
     * перемещению персонажа
     */
    @Override
    public void move() {

    }

    /**
     * Переопределение метода абстрактного класса Person по
     * стерльбе игрока
     */
    @Override
    public void shoot() {

    }

}
