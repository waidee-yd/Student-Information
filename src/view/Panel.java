package view;

import controller.StudentController;
import view.UIHandler.InputHandler;
import view.UIHandler.TableHandler;
import view.UIHandler.TitleHandler;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    JPanel Input = new JPanel();
    JPanel Record = new JPanel();

    JPanel InputPanel = new JPanel();
    JPanel RecordPanel = new JPanel();

    TitleHandler textHandler = new TitleHandler();
    TableHandler tableHandler = new TableHandler();

    StudentController controller = new StudentController(tableHandler);

    //Text Field
    InputHandler inputHandler = new InputHandler(controller);

    public Panel() {
        setLayout(null);

        setBackground(new Color(249, 240, 209));

        textHandler.titleHeader.setOpaque(false);
        textHandler.recordHeader.setOpaque(false);

        inputHandler.fninputField.setOpaque(false);
        inputHandler.fnlabel.setOpaque(false);
        inputHandler.mninputField.setOpaque(false);
        inputHandler.mnlabel.setOpaque(false);
        inputHandler.lninputField.setOpaque(false);
        inputHandler.lnlabel.setOpaque(false);
        inputHandler.clabel.setOpaque(false);
        inputHandler.courseDropdown.setOpaque(false);
        inputHandler.eminputField.setOpaque(false);
        inputHandler.emlabel.setOpaque(false);
        inputHandler.searchBox.setOpaque(false);

        Input.setLayout(null);
        Record.setLayout(null);
        RecordPanel.setLayout(null);
        InputPanel.setLayout(null);

        Input.setBackground(new Color(249, 240, 209));
        Input.setBorder(BorderFactory.createMatteBorder(3,3,3,3, new Color(204, 194, 167)));
        Input.setBounds(10,5, 500,670);

        Record.setBackground(new Color(249, 240, 209));
        Record.setBorder(BorderFactory.createMatteBorder(3,3,3,3, new Color(204, 194, 167)));
        Record.setBounds(535,5,715,670);

        //Panels
        InputPanel.setBackground(new Color(233, 223, 189));
        InputPanel.setBounds(25,100,450,470);

        RecordPanel.setBackground(new Color(249, 240, 209));
        RecordPanel.setBorder(BorderFactory.createMatteBorder(3,3,3,3, new Color(204, 194, 167)));
        RecordPanel.setBounds(25,100,670,520);

        //Adding to UI
        Input.add(textHandler.titleHeader);
        Input.add(InputPanel);

        InputPanel.add(inputHandler.fninputField);
        InputPanel.add(inputHandler.fnlabel);
        InputPanel.add(inputHandler.mninputField);
        InputPanel.add(inputHandler.mnlabel);
        InputPanel.add(inputHandler.lninputField);
        InputPanel.add(inputHandler.lnlabel);
        InputPanel.add(inputHandler.clabel);
        InputPanel.add(inputHandler.courseDropdown);
        InputPanel.add(inputHandler.eminputField);
        InputPanel.add(inputHandler.emlabel);
        InputPanel.add(inputHandler.save);

        Record.add(textHandler.recordHeader);
        Record.add(RecordPanel);
        Record.add(inputHandler.searchBtn);
        Record.add(inputHandler.searchBox);

        tableHandler.setBounds(3,3,664,515);
        RecordPanel.add(tableHandler);

        add(Input);
        add(Record);
    }

}
