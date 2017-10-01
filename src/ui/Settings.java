package ui;

import javax.swing.*;
import java.awt.*;

public class Settings extends JFrame {

    public static boolean language;

    private final String TITLE;
    private final int WIDTH;
    private final int HEIGHT;

    private JLabel lblLanguage;
    private ButtonGroup buttonGroup;
    private JRadioButton rbtnEN;
    private JRadioButton rbtnRU;
    private JPanel contentPanel;

    public Settings(String TITLE, int WIDTH, int HEIGHT) throws HeadlessException {

        this.TITLE = TITLE;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        lblLanguage = new JLabel("Язык интерфейса");
        buttonGroup = new ButtonGroup();
        rbtnEN = new JRadioButton();
        rbtnRU = new JRadioButton();

        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

    }

    public void showWindow(){

        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(contentPanel);

        lblLanguage.setBounds(10,10,150,30);
        contentPanel.add(lblLanguage);

    }

}
