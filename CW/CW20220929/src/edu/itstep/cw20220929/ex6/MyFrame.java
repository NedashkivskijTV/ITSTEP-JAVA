package edu.itstep.cw20220929.ex6;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //JPanel jPanel = new JPanel();
        //JPanel jPanel = new JPanel(new FlowLayout());
        JPanel jPanel = new JPanel(new GridLayout(4, 4));

        jPanel.add(new JButton("button 1"));
        jPanel.add(new JButton("button 2"));
        jPanel.add(new JButton("button 3"));
        jPanel.add(new JButton("button 4"));
        jPanel.add(new JButton("button 5"));
        jPanel.add(new JButton("button 6"));
        jPanel.add(new JButton("button 7"));
        //jPanel.add(new JButton("button 8"));4

        add(jPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
