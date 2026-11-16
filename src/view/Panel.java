package view;

import view.UIHandler.TableHandler;
import view.UIHandler.TitleHandler;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    JPanel InputHandler = new JPanel();
    JPanel RecordHandler = new JPanel();

    JPanel InputPanel = new JPanel();
    JPanel RecordPanel = new JPanel();

    JPanel Top = new JPanel();

    TitleHandler textHandler = new TitleHandler();
    TableHandler tableHandler = new TableHandler();

    public Panel() {
        setLayout(null);

        setBackground(new Color(249, 240, 209));

        textHandler.titleHeader.setOpaque(false);
        textHandler.recordHeader.setOpaque(false);
        InputHandler.setLayout(null);
        RecordHandler.setLayout(null);
        RecordPanel.setLayout(null);

        textHandler.setBounds(10, 10, 480, 60);
        textHandler.setBounds(10, 10, 480, 60);

        //Handler
        InputHandler.setBackground(new Color(249, 240, 209));
        InputHandler.setBorder(BorderFactory.createMatteBorder(3,3,3,3, new Color(204, 194, 167)));
        InputHandler.setBounds(10,5, 500,670);

        RecordHandler.setBackground(new Color(249, 240, 209));
        RecordHandler.setBorder(BorderFactory.createMatteBorder(3,3,3,3, new Color(204, 194, 167)));
        RecordHandler.setBounds(535,5,715,670);

        //Panels
        InputPanel.setBackground(new Color(233, 223, 189));
        InputPanel.setBounds(25,100,450,470);

        RecordPanel.setBackground(new Color(249, 240, 209));
        RecordPanel.setBorder(BorderFactory.createMatteBorder(3,3,3,3, new Color(204, 194, 167)));
        RecordPanel.setBounds(25,100,670,520);

        //Record top bar
        Top.setBackground(new Color(221, 210, 177));
        Top.setBounds(3,3,664,40);

        //Adding to UI
        InputHandler.add(textHandler.titleHeader);
        InputHandler.add(InputPanel);

        RecordHandler.add(textHandler.recordHeader);
        RecordHandler.add(RecordPanel);

        //RecordPanel.add(Top);
        tableHandler.setBounds(3,3,664,515);
        RecordPanel.add(tableHandler);

        add(InputHandler);
        add(RecordHandler);
    }

}
