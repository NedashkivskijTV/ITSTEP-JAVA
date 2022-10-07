package edu.itstep.cw20220929.ex5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.InputStream;

public class MyFrame extends JFrame {

    public MyFrame(){
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("Button");

        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl I");
        InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        String key = "print smile";
        inputMap.put(keyStroke, key);

        ActionMap actionMap = jPanel.getActionMap();
        actionMap.put(key, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(":-)");
            }
        });

        jPanel.add(jButton);
        add(jPanel);

        setVisible(true);
    }

    public static void printSmile(ActiveEvent e){
        System.out.println(":-)");
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();

    }
}
