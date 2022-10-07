package edu.itstep.cw20220929.ex2;

import javax.swing.*;
import java.awt.*;

public class SecondFrame extends JFrame {

    private JPanel jPanel;
    private JButton jButton1;
    private JButton jButton2;

    public SecondFrame(){
        setSize();
        init();
        addListeners();
    }
    private void setSize(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    private void init(){
        jPanel = new JPanel();
        jButton1 = new JButton("Button1");
        jButton2 = new JButton("Button22222");

        jPanel.add(jButton1);
        jPanel.add(jButton2);

        this.add(jPanel);
    }
    private void addListeners(){
        jButton1.addActionListener(e -> {
            jPanel.setBackground(new Color(41, 255, 10));
            System.out.println("clicked # 1");
        });

        jButton2.addActionListener(e -> {
            jPanel.setBackground(new Color(222, 0, 0));
            System.out.println("clicked # 2");
        });
    }

    public static void main(String[] args) {
        SecondFrame secondFrame = new SecondFrame();
        secondFrame.setVisible(true);
    }
}
