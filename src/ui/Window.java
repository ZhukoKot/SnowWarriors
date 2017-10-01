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
public class Window extends JFrame {

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
    private JButton btnInfo;
    private JButton btnExitGame;

    /**
     * Переменная реализующая панель для компонентов формы
     * @variable contaentPanel - основная панель формы
     */
    private JPanel contentPanel;

    JLabel label;

    /**
     * Конструктор класса, принимающий три параметра, в нем происходит
     * задание окну названия и размеров, выделение памяти, также установка стандартной
     * операции выхода по нажатию на крестик и устанавливается не
     * изменяемый вид окна
     * @param TITLE - название окна
     * @param WIDTH - ширина окна
     * @param HEIGHT - высота окна
     */
    public Window(String TITLE, int WIDTH, int HEIGHT) {

        //Прием данных с конструктора и запись их в переменные класса
        this.TITLE = TITLE;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        //Выделение памяти для компонентов формы
        btnStartGame = new JButton("Начать игру");
        btnSettings = new JButton("Настройки");
        btnInfo = new JButton("Об игре");
        btnExitGame = new JButton("Выход");
        contentPanel = new JPanel();

        //Здание основных параметров окна
        Image icon = new ImageIcon("src/res/icon.png").getImage();
        setIconImage(icon);
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    /**
     * Метод выполняющий вывод окна на экран, в нем устанавливаются слушатели
     * и обработчики событий для кнопок, которые расположены на форме
     */
    public void showWindow(){

        //Показываем наше окно и устанавливаем главную панель @variable contaentPanel
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(contentPanel);

        ImageIcon icon = new ImageIcon("src/res/main_img.jpg");
        label = new JLabel(icon);;

        //Устанавливаем границы и расположение панели @variabel contaentPanel
        contentPanel.setBorder(new EmptyBorder(1,1,1,1));
        contentPanel.setLayout(null);

        //Добавляем элементы в форму, при помощи задания им координат
        btnStartGame.setBounds(10,10,150,30);
        contentPanel.add(btnStartGame);
        btnSettings.setBounds(10, 50,150,30);
        contentPanel.add(btnSettings);
        btnInfo.setBounds(10,90,150,30);
        contentPanel.add(btnInfo);
        btnExitGame.setBounds(10,130,150,30);
        contentPanel.add(btnExitGame);
        contentPanel.add(label).setBounds(170,0,825,600);

        //Обработки события на нажатие кнопки @variable btnStartGame
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        //Обработка события на нажатие кнопки @variable btnSettings
        btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Обработка события на нажатие кнопки @variable btnInfo
        btnInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Вывод MessageBox
                JOptionPane.showMessageDialog( null, "Данную игру разработали студенты ТИ ДГТУ:\n" +
                                                "Балун В. - Инженер-программист\n" +
                                                "Жуков Ю. - Программист / звукорежисер\n" +
                                                "Евдокимов Я. - Программист / графический дизайнер");
            }
        });

        //Обработка события на нажатие кнопки @variable btnExitGame
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


    }

    /**
     * Метод начинающий игру, в нем будет реализован процесс перерисовки
     * экрана за каждую единицу времени
     */
    public void startGame(){

        //Удаляем кнопки с формы
        contentPanel.remove(btnStartGame);
        contentPanel.remove(btnSettings);
        contentPanel.remove(btnExitGame);
        contentPanel.remove(btnInfo);
        contentPanel.remove(label);

        //Начинает отрисовку игровой сцены
        Scene scene = new Scene(WIDTH, HEIGHT);
        scene.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(scene);
        this.pack();
        scene.start();

    }

}
