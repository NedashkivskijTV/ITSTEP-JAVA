package edu.itstep.cw20220929_repeat.Ex3;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE); // дії при закритті вікна - вихід при закритті
        setSize(500, 500); // встановлює розміри
        setLocationRelativeTo(null); // встановлює положення - центр екрана

        JPanel jPanel = new JPanel();

        JButton jButton = new JButton("Button"); // кнопка

        JTextField jTextField = new JTextField("name", 10); // текстове поле (в один рядок)
        // параметри - текст за замовчуванням - плейсхолдер, ширина - кількість найширших символів (W)

        JTextArea jTextArea = new JTextArea(5, 10); // текстовий блок (параметри - рядка та колонки)
        jTextArea.setLineWrap(true); // налаштування текстового блоку - перехід на наступний рядок (слова розбиваються при переносі)
        jTextArea.setWrapStyleWord(true); // налаштування текстового блоку - при переносі слова НЕ розбиваються
        JScrollPane jScrollPane = new JScrollPane( // додавання панелі склолінга - окремий об'єкт - є обгорткою для об'єкта до якого застосовується
                jTextArea, // обєкт до якого застосовується скролінг
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // поведінка вертикального скролінга задається константами
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER // поведінка горизонтального скролінга задається константами
        );

        JLabel jLabel = new JLabel("Input your message: "); // поле для відображення тексту

        jPanel.add(jButton);
        jPanel.add(jTextField);
        //jPanel.add(jTextArea); // закоментовано після додавання панелі скролінга
        jPanel.add(jLabel);
        jPanel.add(jScrollPane);

        add(jPanel); // доєднання панелі до вікна

        setVisible(true); // візуалізація вікна - вказується обов'язково вкінці, щоб відмалювались усі об'єкти
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
