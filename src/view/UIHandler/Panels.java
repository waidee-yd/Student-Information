package view.UIHandler;

import view.WindowHandler;

import javax.swing.*;
import java.awt.*;

public class Panels extends JPanel {

    public Panels() {
        setLayout(null);

        JPanel InputPanel = new JPanel();
        InputPanel.setBackground(Color.cyan);
        InputPanel.setBounds(10,5, 500,670);

        JPanel RecordPanel = new JPanel();
        RecordPanel.setBackground(Color.green);
        RecordPanel.setBounds(560,5,500,670);

        add(InputPanel);
        add(RecordPanel);


    }

}
