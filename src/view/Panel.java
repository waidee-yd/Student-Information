package view;

import controller.StudentController;
import controller.ThemeSettings;
import view.UIHandler.InputHandler;
import view.UIHandler.TableHandler;
import view.UIHandler.TitleHandler;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    ThemeSettings theme = new ThemeSettings();

    JPanel Input = new JPanel();
    JPanel Record = new JPanel();

    JPanel InputPanel = new JPanel();
    JPanel RecordPanel = new JPanel();

    TitleHandler textHandler = new TitleHandler();
    TableHandler tableHandler = new TableHandler();

    StudentController controller = new StudentController(tableHandler);

    //Text Field
    InputHandler inputHandler = new InputHandler(controller,tableHandler);

    public Panel() {
        setLayout(null);

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

        if (theme.isDarkMode()) {
            DarkMode();
        } else {
            LightMode();
        }

        Input.setBounds(10,5, 500,630);


        Record.setBounds(535,5,715,630);

        //Panels
        InputPanel.setBounds(25,100,450,470);

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

    public void DarkMode() {
        setBackground(new Color(28, 34, 50));

        Input.setBackground(new Color(28, 34, 50));
        Input.setBorder(BorderFactory.createMatteBorder(3,3,3,3, new Color(74, 81, 91)));

        Record.setBackground(new Color(28, 34, 50));
        Record.setBorder(BorderFactory.createMatteBorder(3,3,3,3, new Color(74, 81, 91)));

        InputPanel.setBackground(new Color(39, 47, 68));

        RecordPanel.setBackground(new Color(28, 34, 50));
        RecordPanel.setBorder(BorderFactory.createMatteBorder(3,3,3,3, new Color(74, 81, 91)));

        tableHandler.scrollPane.getViewport().setBackground(new Color(28, 34, 50));
        tableHandler.scrollPane.setBackground(new Color(28, 34, 50));

        tableHandler.dataTable.setBackground(new Color(28, 34, 50));
        tableHandler.dataTable.setForeground(new Color(240, 240, 240));
        tableHandler.dataTable.setGridColor(new Color(42, 49, 68));

        tableHandler.header.setBackground(new Color(42, 49, 68));
        tableHandler.header.setForeground(new Color(240, 240, 240));

        inputHandler.courseDropdown.setBackground(new Color(28, 34, 50));
        inputHandler.courseDropdown.setForeground(new Color(240, 240, 240));
        inputHandler.searchBox.setForeground(new Color(240, 240, 240));
        inputHandler.fnlabel.setForeground(new Color(240, 240, 240));
        inputHandler.mnlabel.setForeground(new Color(240, 240, 240));
        inputHandler.lnlabel.setForeground(new Color(240, 240, 240));
        inputHandler.clabel.setForeground(new Color(240, 240, 240));
        inputHandler.emlabel.setForeground(new Color(240, 240, 240));

        inputHandler.fninputField.setForeground(new Color(240, 240, 240));
        inputHandler.mninputField.setForeground(new Color(240, 240, 240));
        inputHandler.lninputField.setForeground(new Color(240, 240, 240));
        inputHandler.eminputField.setForeground(new Color(240, 240, 240));

        inputHandler.searchBtn.setBackground(new Color(147, 168, 114));

        inputHandler.fninputField.setCaretColor(new Color(240, 240, 240));
        inputHandler.mninputField.setCaretColor(new Color(240, 240, 240));
        inputHandler.lninputField.setCaretColor(new Color(240, 240, 240));
        inputHandler.eminputField.setCaretColor(new Color(240, 240, 240));
        inputHandler.searchBox.setCaretColor(new Color(240, 240, 240));

        textHandler.titleHeader.setForeground(new Color(240, 240, 240));
        textHandler.recordHeader.setForeground(new Color(240, 240, 240));
    }

    public void LightMode() {
        setBackground(new Color(249, 240, 209));

        Input.setBackground(new Color(249, 240, 209));
        Input.setBorder(BorderFactory.createMatteBorder(3,3,3,3, new Color(204, 194, 167)));

        Record.setBackground(new Color(249, 240, 209));
        Record.setBorder(BorderFactory.createMatteBorder(3,3,3,3, new Color(204, 194, 167)));

        InputPanel.setBackground(new Color(233, 223, 189));

        RecordPanel.setBackground(new Color(249, 240, 209));
        RecordPanel.setBorder(BorderFactory.createMatteBorder(3,3,3,3, new Color(204, 194, 167)));

        tableHandler.scrollPane.getViewport().setBackground(new Color(249,240,209));
        tableHandler.scrollPane.setBackground(new Color(249,240,209));

        tableHandler.dataTable.setBackground(new Color(249, 240, 209));
        tableHandler.dataTable.setForeground(new Color(60, 42, 33));
        tableHandler.dataTable.setGridColor(new Color(221, 210, 177));

        tableHandler.header.setBackground(new Color(221, 210, 177));
        tableHandler.header.setForeground(new Color(60, 42, 33));

        inputHandler.courseDropdown.setBackground(new Color(249, 240, 209));
        inputHandler.courseDropdown.setForeground(new Color(60, 42, 33));
        inputHandler.searchBox.setForeground(new Color(60, 42, 33));
        inputHandler.fnlabel.setForeground(new Color(60, 42, 33));
        inputHandler.mnlabel.setForeground(new Color(60, 42, 33));
        inputHandler.lnlabel.setForeground(new Color(60, 42, 33));
        inputHandler.clabel.setForeground(new Color(60, 42, 33));
        inputHandler.emlabel.setForeground(new Color(60, 42, 33));

        inputHandler.fninputField.setForeground(new Color(60, 42, 33));
        inputHandler.mninputField.setForeground(new Color(60, 42, 33));
        inputHandler.lninputField.setForeground(new Color(60, 42, 33));
        inputHandler.eminputField.setForeground(new Color(60, 42, 33));

        inputHandler.searchBtn.setBackground(new Color(137, 157, 106));

        inputHandler.fninputField.setCaretColor(new Color(60, 42, 33));
        inputHandler.mninputField.setCaretColor(new Color(60, 42, 33));
        inputHandler.lninputField.setCaretColor(new Color(60, 42, 33));
        inputHandler.eminputField.setCaretColor(new Color(60, 42, 33));
        inputHandler.searchBox.setCaretColor(new Color(60, 42, 33));

        textHandler.titleHeader.setForeground(new Color(60, 42, 33));
        textHandler.recordHeader.setForeground(new Color(60, 42, 33));
    }

}
