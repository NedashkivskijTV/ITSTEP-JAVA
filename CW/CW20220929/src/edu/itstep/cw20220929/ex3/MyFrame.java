package edu.itstep.cw20220929.ex3;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);

        JPanel jPanel = new JPanel();

        JButton jButton = new JButton("Button");
        JTextField jTextField = new JTextField("name", 10);
        JTextArea jTextArea = new JTextArea(5, 10);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        JScrollPane jScrollPane = new JScrollPane(
                jTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        jPanel.add(jButton);
        jPanel.add(jTextField);
        //jPanel.add(jTextArea);
        jPanel.add(jScrollPane);

        add(jPanel);

        setVisible(true);

    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.setVisible(true);
    }

}
