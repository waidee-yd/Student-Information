package view;

import view.UIHandler.PanelHandler;

import javax.swing.*;
import java.awt.*;

public class WindowHandler {

    public WindowHandler() {

        // Window Frame
        JFrame frameWindow = new JFrame("Student Information");

        frameWindow.setSize(1280, 720);
        frameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWindow.setResizable(false);
        frameWindow.getContentPane().setBackground(new Color(249, 240, 209));

        //PanelHandler
        PanelHandler panel = new PanelHandler();
        frameWindow.add(panel);


        frameWindow.setVisible(true);
    }

}
