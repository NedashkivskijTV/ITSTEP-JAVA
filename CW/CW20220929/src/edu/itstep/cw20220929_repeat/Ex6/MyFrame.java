package edu.itstep.cw20220929_repeat.Ex6;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {

        // застосування Лейаутів - LayoutManager

        setDefaultCloseOperation(EXIT_ON_CLOSE); // дії при закритті вікна - вихід при закритті
        setSize(500, 500); // встановлює розміри
        setLocationRelativeTo(null); // встановлює положення - центр екрана

        //JPanel jPanel = new JPanel(); // панель без лейаута - розміщення елементів за замовчуванням - зверху посередині вікна

        //JPanel jPanel = new JPanel(new FlowLayout()); // FlowLayout - розміщення елементів за замовчуванням - зверху посередині вікна

        JPanel jPanel = new JPanel(new GridLayout(4, 4)); // GridLayout - розміщення елементів як в таблиці (рядків, колонок)

/*
        JPanel jPanel = new JPanel(new BorderLayout()); // BorderLayout - розбиває панель на північну, східну, південну, західну, центральну частини
        jPanel.add(new JButton("button 1"), BorderLayout.NORTH);
        jPanel.add(new JButton("button 2"), BorderLayout.SOUTH);
        jPanel.add(new JButton("button 3"), BorderLayout.EAST);
        jPanel.add(new JButton("button 4"), BorderLayout.WEST);
        jPanel.add(new JButton("button 5"), BorderLayout.CENTER);
*/

        //JPanel jPanel = new JPanel(new BoxLayout(this, BoxLayout.Y_AXIS)); // BoxLayout - допомагає розмістити елементи по вертикалі/горизонталі
                                                                                // !!! - працює при наслідуванні від класу Frame

        // створення та ініціалізація кнопок в циклі
        for (int i = 0; i < 7; i++) {
            jPanel.add(new JButton("button " + (i + 1)));
        }


        add(jPanel); // доєднання панулі до вікна
        setVisible(true); // команда на візуалізацію вікна
    }

    // точка доступу
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
