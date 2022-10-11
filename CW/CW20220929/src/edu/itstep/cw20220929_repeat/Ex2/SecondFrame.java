package edu.itstep.cw20220929_repeat.Ex2;

import javax.swing.*;
import java.awt.*;

public class SecondFrame extends JFrame {

    private JPanel jPanel; // обєкт jPanel - в нього поміщуються всі об'єкти
    private JButton jButton1; // кнопка
    private JButton jButton2; // кнопка

    public SecondFrame(){
        setFrame(); // встановлення розмірів, положення та інших налаштувань вікна
        init(); // ініціалізація об'єктів
        addListeners(); // вствновлення налаштувань активних об'єктів - натискання кнопок ...
    }

    private void setFrame(){
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // дії при закритті вікна - вихід при закритті
        // інший варіант виклику кинстанти (вона також міститься у самому вікні)
        setDefaultCloseOperation(EXIT_ON_CLOSE); // дії при закритті вікна - вихід при закритті
        setSize(500, 500); // встановлює розміри
        setLocationRelativeTo(null); // встановлює положення - центр екрана
    }
    private void init(){
        jPanel = new JPanel(); // ініціалізація об'єктів
        jButton1 = new JButton("Button1");
        jButton2 = new JButton("Button222");

        jPanel.add(jButton1); // додавання об'єктів до jPanel - розташування об'єктів залежить від застосованого лейаута
        jPanel.add(jButton2);
        this.add(jPanel); // додавання панелі до вікна
    }

    private void addListeners(){
        // активні можливості об'єктів задаються через інтерфейс addActionListener
        //ActionListener - функціональний інтерфейс - дія задається за доп. лямбди, посилання на об'єкт анонімного класу, посилання на метод
        jButton1.addActionListener(e -> {
            jPanel.setBackground(new Color(41, 255, 0));
            System.out.println("clicked Button1");
        });

        jButton2.addActionListener(e -> {
            jPanel.setBackground(new Color(255, 128, 0));
            System.out.println("clicked Button2");
        });
    }


    public static void main(String[] args) {
        SecondFrame secondFrame = new SecondFrame();
        secondFrame.setVisible(true);
    }
}
