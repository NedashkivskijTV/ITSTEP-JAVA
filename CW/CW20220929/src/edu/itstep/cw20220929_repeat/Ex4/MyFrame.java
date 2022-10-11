package edu.itstep.cw20220929_repeat.Ex4;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends JFrame {
    public MyFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE); // дії при закритті вікна - вихід при закритті
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        // доєднання обробника подій

        // анонімний клас WindowListener - велика кількість коду - застосовується якщо
        // потрібно власноруч прописати усі варіанти спрацювання
        // або навпаки вимкнути певний стандартний обробник (залишити тіло методу пустим)
//        addWindowListener(new WindowListener() {
//            @Override
//            public void windowOpened(WindowEvent e) {
//                System.out.println("windowOpened");
//            }
//
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.out.println("windowClosing");
//            }
//
//            @Override
//            public void windowClosed(WindowEvent e) {
//                System.out.println("windowClosed");
//            }
//
//            @Override
//            public void windowIconified(WindowEvent e) {
//                System.out.println("windowIconified");
//            }
//
//            @Override
//            public void windowDeiconified(WindowEvent e) {
//                System.out.println("windowDeiconified");
//            }
//
//            @Override
//            public void windowActivated(WindowEvent e) {
//                System.out.println("windowActivated");
//            }
//
//            @Override
//            public void windowDeactivated(WindowEvent e) {
//                System.out.println("windowDeactivated");
//            }
//        });


//===================================================================
        // абстрактний клас WindowAdapter - дозоляє обрати один з методів
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                System.out.println("windowOpened");
            }
        });

    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
