package edu.itstep.cw20220929_repeat.Ex7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFirstGuiForm extends JFrame{
    private JPanel mainJPanel;
    private JButton button1;
    private JTextField textField1;
    private JLabel label1;

    public MyFirstGuiForm(){
        setDefaultCloseOperation(EXIT_ON_CLOSE); // дії при закритті вікна - вихід при закритті
        setSize(500, 500); // встановлює розміри
        setLocationRelativeTo(null); // встановлює положення - центр екрана


        add(mainJPanel); // додається головна панель - елементи до панелі додані автоматично
        addActionListeners(); // додавання обробників

        setVisible(true); // команда на візуалізацію вікна
    }

    private void addActionListeners(){
        // до елементів можна звернутись, як до проініціалізованих об'єктів

        // відображення тексту з текстового поля textField1 у елементі label1
        button1.addActionListener(e -> {
            String message = textField1.getText();
            label1.setText(message);
        });
    }
}
