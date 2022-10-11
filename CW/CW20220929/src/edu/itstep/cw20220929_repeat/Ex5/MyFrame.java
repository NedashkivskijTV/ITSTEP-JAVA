package edu.itstep.cw20220929_repeat.Ex5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{
    public MyFrame(){

        // встановлення події - по натисканню кнопки в консолі друкується смайл

        setDefaultCloseOperation(EXIT_ON_CLOSE); // дії при закритті вікна - вихід при закритті
        setSize(500, 500); // встановлює розміри
        setLocationRelativeTo(null); // встановлює положення - центр екрана

        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("Button"); // кнопка

        // додавання події до кнопки
        // 1 - посилання на метод (потребеє створення класу, у методі якого реалізована логіка)
//        jButton.addActionListener(new SmileAction()); // встановлення події (через посилання на метод) - натискання на кнопку - смайл у консоль

        // 2 - посилання на об'єкт анонімного класу
//        jButton.addActionListener(new AbstractAction() { // встановлення події - натискання на кнопку - смайл у консоль
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                printSmileShortKey(e);
//            }
//        });

        // 3 - лямбда
        jButton.addActionListener(e -> {
            System.out.println(";)");
        });

        //===============================================================
        // налаштування події - комбінація клавіш - смайл у консоль
        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl S"); // встанволення комбінації клавіш по якому спрацює подія
        InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW); // встановлення випадку спрацювання події - фокус на вікні
        String key = "print smile"; // вибір унікального ключа - зазвичай називається по дії, що відбуватиметься
        inputMap.put(keyStroke, key); // вказується, що дана робота виконуватиметься по такій комбінації клавіш

        ActionMap actionMap = jPanel.getActionMap(); // отримання об'єкта ActionMap - є у кожної jPanel

        // додавання події, що спрацьовуватиме при натисканні комбінації клавіш
        // 1 - посилання на метод (потребеє створення класу, у методі якого реалізована логіка)
//        actionMap.put(key, new SmileAction()); // додавання події, що відбуватиметься по комбінації клавіш

        // 2 - посилання на об'єкт анонімного класу
        actionMap.put(key, new AbstractAction() { // створення коду (через об'єкт анонімного класу AbstractAction)
                                                  // для виконання конкретної дії, що відбуватиметься по натисканні
                                                  // комбінації клавіш
            @Override
            public void actionPerformed(ActionEvent e) {
                // в тілі методу описується що потрібно зробити
                //System.out.println(";)"); // код реалізується у тілі методу анонімного класу
                printSmileShortKey(e); // псилання на метод, де реалізованоалгоритм - може використовуватись у декількох різних місцях без дублікації коду
            }
        });

        jPanel.add(jButton); // доєднання кнопки до панелі
        add(jPanel); // доєднання панулі до вікна

        setVisible(true); // команда на візуалізацію вікна
    }

    // метод для виконання дії і натисканням на кнопку і гарячими клавішами
    public static void printSmileShortKey(ActionEvent e){
        System.out.println(";)");
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
