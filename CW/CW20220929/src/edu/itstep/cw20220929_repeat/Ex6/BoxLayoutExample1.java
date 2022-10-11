package edu.itstep.cw20220929_repeat.Ex6;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutExample1 extends Frame {
    Button buttons[];

    public BoxLayoutExample1() {
        buttons = new Button[5];

        for (int i = 0; i < 5; i++) {
            buttons[i] = new Button("button " + (i + 1));
            add(buttons[i]);
        }

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(500, 500); // встановлює розміри
        setLocationRelativeTo(null); // встановлює положення - центр екрана
        setVisible(true);
    }

    public static void main(String[] args) {
        BoxLayoutExample1 b = new BoxLayoutExample1();
    }

}
