package view.UIHandler;

import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputHandler extends JPanel implements ActionListener {

    Student student = new Student();

    String[] courseList = student.courseList;

    public JComboBox<String> courseDropdown = new JComboBox<>(courseList);

    public JTextField fninputField = new JTextField();
    public JTextField mninputField = new JTextField();
    public JTextField lninputField = new JTextField();
    public JTextField eminputField = new JTextField();

    public JLabel fnlabel = new JLabel();
    public JLabel mnlabel = new JLabel();
    public JLabel lnlabel = new JLabel();
    public JLabel clabel = new JLabel();
    public JLabel emlabel = new JLabel();

    public JButton save = new JButton();

    public InputHandler() {
        firstName();
        middleName();
        lastName();
        course();
        email();
        saveButton();
    }

    public void firstName() {
        setLayout(null);
        setOpaque(false);

        fnlabel.setText("First Name:");
        fnlabel.setFont(new Font("Segoe UI", Font.PLAIN,16));
        fnlabel.setBounds(30,50,100,25);
        fninputField.setBounds(150,50,275,25);

        add(fnlabel);
        add(fninputField);

    }

    public void middleName() {
        setLayout(null);
        setOpaque(false);

        mnlabel.setText("Middle Name:");
        mnlabel.setFont(new Font("Segoe UI", Font.PLAIN,16));
        mnlabel.setBounds(30,100,100,25);
        mninputField.setBounds(150,100,275,25);

        add(mnlabel);
        add(mninputField);
    }

    public void lastName() {
        setLayout(null);
        setOpaque(false);

        lnlabel.setText("Last Name:");
        lnlabel.setFont(new Font("Segoe UI", Font.PLAIN,16));
        lnlabel.setBounds(30,150,100,25);
        lninputField.setBounds(150,150,275,25);

        add(lnlabel);
        add(lninputField);
    }

    public void course() {
        setLayout(null);
        setOpaque(false);

        clabel.setText("Course:");
        clabel.setFont(new Font("Segoe UI", Font.PLAIN,16));
        clabel.setBounds(30,200,100,25);

        courseDropdown.setBounds(150,200,275,25);
        courseDropdown.setFont(new Font("Segoe UI", Font.PLAIN,14));
        courseDropdown.setBackground(new Color(249, 240, 209));
        courseDropdown.setForeground(new Color(60, 42, 33));

        add(clabel);
        add(courseDropdown);

    }

    public void email() {
        setLayout(null);
        setOpaque(false);

        emlabel.setText("Email:");
        emlabel.setFont(new Font("Segoe UI", Font.PLAIN,16));
        emlabel.setBounds(30,250,100,25);
        eminputField.setBounds(150,250,275,25);

        add(emlabel);
        add(eminputField);
    }

    public void saveButton() {
        setLayout(null);
        setOpaque(false);

        save.setText("SAVE TO DATABASE");
        save.setFont(new Font("Segoe UI", Font.BOLD,24));
        save.setBounds(30,320,400,40);
        save.setBackground(new Color(137, 157, 106));
        save.setForeground(new Color(247, 254, 214));
        save.addActionListener(this);

        add(save);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save) {
            System.out.println("Saved!");
        }
    }
}
