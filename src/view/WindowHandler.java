package view;

import view.UIHandler.Panels;

import javax.swing.*;

public class WindowHandler {

    public WindowHandler() {

        // Window Frame
        JFrame frameWindow = new JFrame("Student Information");

        frameWindow.setSize(1280, 720);
        frameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWindow.setResizable(false);

        //Panels
        Panels panel = new Panels();
        frameWindow.add(panel);


        frameWindow.setVisible(true);
    }

}
