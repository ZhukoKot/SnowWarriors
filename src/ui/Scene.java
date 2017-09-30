package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс реализует внешний вид основного окна игры
 * @author Балун Владимир
 */
public class Scene extends JFrame {

    /**
     * Переменные описывающие свойства окна
     * @variable TITLE - название окна
     * @variable WIDTH - ширина окна
     * @variable HEIGHT - высота окна
     */
    private final String TITLE;
    private final int WIDTH;
    private final int HEIGHT;

    /**
     * Переменные описывающие кнопки на форме
     * @variable btnStartGame - кнопка начала игры
     * @variable btnStartGame - кнопка настроеек
     * @variable btnStartGame - кнопка выйти из игры
     */
    private JButton btnStartGame;
    private JButton btnSettings;
    private JButton btnExitGame;

    /**
     * Переменная реализующая панель для компонентов формы
     * @variable contaentPanel - основная панель формы
     */
    private JPanel contentPanel;

    /**
     * Конструктор класса, принимающий три параметра, в нем происходит
     * задание окну названия и размеров, выделение памяти, также установка стандартной
     * операции выхода по нажатию на крестик и устанавливается не
     * изменяемый вид окна
     * @param TITLE - название окна
     * @param WIDTH - ширина окна
     * @param HEIGHT - высота окна
     */
    public Scene(String TITLE, int WIDTH, int HEIGHT) {

        //Прием данных с конструктора и запись их в переменные класса
        this.TITLE = TITLE;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        //Выделение памяти для компонентов формы
        btnStartGame = new JButton("Начать игру");
        btnSettings = new JButton("Настройки");
        btnExitGame = new JButton("Выход");
        contentPanel = new JPanel();

        //Здание основных параметров окна
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    /**
     * Метод выполняющий вывод окна на экран, в нем устанавливаются слушатель
     * по нажатия на кнопку @variable btnStartGame, который запускает игру
     */
    public void showScene(){

        //Показываем наше окно и устанавливаем главную панель @variable contaentPanel
        setVisible(true);
        setContentPane(contentPanel);

        //Устанавливаем границы и расположение панели @variabel contaentPanel
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        contentPanel.setLayout(null);

        //Добавляем элементы в форму, при помощи задания им координат
        btnStartGame.setBounds(10,10,150,30);
        contentPanel.add(btnStartGame);
        btnSettings.setBounds(10, 50,150,30);
        contentPanel.add(btnSettings);
        btnExitGame.setBounds(10,90,150,30);
        contentPanel.add(btnExitGame);

        //Обработки события на нажатие кнопки @variable btnStartGame
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Пока только тестовая реализация обработчика
                contentPanel.remove(btnStartGame);
                contentPanel.remove(btnSettings);
                contentPanel.remove(btnExitGame);
                renderingGame();

            }
        });

    }

    /**
     * Метод начинающий игру, в нем будет реализован процесс перерисовки
     * экрана за каждую единицу времени
     */
    public void renderingGame(){

            //Тестовая реализация рендеринга игры
            contentPanel.setBackground(Color.BLACK);

    }


}
