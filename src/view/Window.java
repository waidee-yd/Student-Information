package view;

import controller.CounterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {

    CounterController counterController = new CounterController();

    String[] methods = {"Standard Counter", "Regex Counter"};
    JComboBox<String> methodBox = new JComboBox<>(methods);

    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu about = new JMenu("About");

    JMenuItem exit = new JMenuItem("Exit");
    JMenuItem settings = new JMenuItem("Settings");

    JButton confirm = new JButton();

    JRadioButton on = new JRadioButton("On");
    JRadioButton off = new JRadioButton("Off");

    public Window() {

        this.setTitle("Student Information");
        JMenuBar menuBar = new JMenuBar();

        // Top Bar
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(about);

        // Menu Item

        file.add(exit);
        edit.add(settings);

        settings.addActionListener(this);
        exit.addActionListener(this);


        // Window Frame
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(249, 240, 209));
        this.setJMenuBar(menuBar);

        //Panel
        Panel panel = new Panel();
        this.add(panel);


        this.setVisible(true);
    }

    private void Settings() {
        JDialog settingsTab = new JDialog(this, "Settings", true);
        JLabel displayLabel = new JLabel("Dark Mode");

        ButtonGroup group = new ButtonGroup();
        group.add(on);
        group.add(off);

        // Settings Tab
        settingsTab.setSize(250,250);
        settingsTab.setLocationRelativeTo(this);
        settingsTab.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel settingPanel = new JPanel();
        settingPanel.setLayout(null);
        settingPanel.setSize(500,250);

        if (CounterController.getMethod() != 1) {
            methodBox.setSelectedIndex(1);
        } else {
            methodBox.setSelectedIndex(0);
        }
        methodBox.setBounds(40,40,150,25);

        displayLabel.setBounds(40,75,100,25);
        on.setBounds(45,85,50,50);
        off.setBounds(45,105,50,50);

        confirm.setText("Confirm & Apply");
        confirm.setBounds(20,160,200,25);

        for (ActionListener action : confirm.getActionListeners()) {
            confirm.removeActionListener(action);
        }
        confirm.addActionListener(ev -> {
            if (methodBox.getSelectedIndex() == 0) {
                CounterController.setMethod(1);
            } else {
                CounterController.setMethod(0);
            }
            settingsTab.dispose();
            System.out.println(CounterController.getMethod());
        });

        methodBox.setOpaque(false);
        displayLabel.setOpaque(false);
        confirm.setOpaque(false);
        on.setOpaque(false);
        off.setOpaque(false);

        settingPanel.add(methodBox);
        settingPanel.add(displayLabel);
        settingPanel.add(confirm);
        settingPanel.add(on);
        settingPanel.add(off);

        settingsTab.add(settingPanel);
        settingsTab.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == settings) {
            Settings();
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}
