package view.UIHandler;

import javax.swing.*;
import java.awt.*;

public class PanelHandler extends JPanel {

    JPanel InputHandler = new JPanel();
    JPanel RecordHandler = new JPanel();

    JPanel InputPanel = new JPanel();
    JPanel RecordPanel = new JPanel();

    TextHandler textHandler = new TextHandler();

    public PanelHandler() {
        setLayout(null);

        setBackground(new Color(249, 240, 209));

        textHandler.titleHeader.setOpaque(false);
        textHandler.recordHeader.setOpaque(false);
        InputHandler.setLayout(null);
        RecordHandler.setLayout(null);

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

        //Adding to UI
        InputHandler.add(textHandler.titleHeader);
        InputHandler.add(InputPanel);

        RecordHandler.add(textHandler.recordHeader);
        RecordHandler.add(RecordPanel);

        add(InputHandler);
        add(RecordHandler);
    }

}
