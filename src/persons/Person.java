package persons;

import java.awt.*;

/**
 * Абстрактный класс описывает поведение персножам
 * игры(игроку, врагам, боссам), а именно описывает им здоровье,
 * мощь(сколько жизней будет отниматься от выстрела), перемещение
 * и стрельбу
 * @author Балун Владимир
 */
abstract class Person {

    /**
     * Переменные абстрактного класса описывающие свойства
     * @variable health - здоровье персонажа
     * @variable potency - мощь персноажа(сколько жизней будет отниматься от выстрела)
     * @variable positionX - позиция персонажа по Х
     * @variable positionY -  позиция персонажа по Y
     */
    private int health;
    private int potency;
    private int positionX;
    private int positionY;

    /**
     * Конструктор класса задающий здоровье и мощь классам, которые
     * наследуют этот класс
     * @param health - здоровье персонажа
     * @param potency - мощь персонажа(сколько жизней будет отниматься от выстрела)
     * @param X - позиция по Х
     * @param Y - позиция по Y
     */
    public Person(int health, int potency, int X, int Y) {
        this.health = health;
        this.potency = potency;
        this.positionX = X;
        this.positionY = Y;
    }

    /**
     * Getters and Setters возвращающие и устанавливающие
     * здоровье, мощь персонажуа и координаты на игровом поле
     */
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getPotency() {
        return potency;
    }
    public void setPotency(int potency) {
        this.potency = potency;
    }
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
    /**
     * Методы абстрактного класса описывающие поведение
     * @function move - перемещение игрока
     * @function shoot - стрельба игрока
     * @function draw - отрисовка персонажа
     */
    abstract public void move();
    abstract public void shoot();
    abstract public void draw(Graphics graphic);

}
