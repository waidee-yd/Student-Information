package view.UIHandler;

import javax.swing.*;
import java.awt.*;

public class TextHandler extends JPanel {

    JLabel titleHeader = new JLabel("Student Information");
    JLabel recordHeader = new JLabel("Records");

    public TextHandler() {
        title();
        record();
    }

    public void title() {
        setLayout(null);
        setOpaque(false);

        titleHeader.setFont(new Font("Garamond", Font.BOLD, 32));
        titleHeader.setForeground(Color.black);
        titleHeader.setBounds(20, 20, 400, 40);

        add(titleHeader);
    }

    public void record() {
        setLayout(null);
        setOpaque(false);

        recordHeader.setFont(new Font("Garamond", Font.BOLD, 32));
        recordHeader.setForeground(Color.black);
        recordHeader.setBounds(20, 20, 400, 40);

        add(recordHeader);
    }


}
