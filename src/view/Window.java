package view;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window() {

        // Window Frame
        JFrame frameWindow = new JFrame("Student Information");

        frameWindow.setSize(1280, 720);
        frameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWindow.setResizable(false);
        frameWindow.getContentPane().setBackground(new Color(249, 240, 209));

        //Panel
        Panel panel = new Panel();
        frameWindow.add(panel);


        frameWindow.setVisible(true);
    }

}
