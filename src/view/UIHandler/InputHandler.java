package view.UIHandler;

import controller.Search;
import controller.StudentController;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputHandler extends JPanel implements ActionListener {

    Student student = new Student();
    StudentController controller = new StudentController();

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

    public JTextField searchBox = new JTextField();
    public JButton searchBtn = new JButton();

    private TableHandler th;

    public InputHandler(StudentController controllers, TableHandler tableHandler) {
        this.controller = controllers;
        this.th = tableHandler;
        firstName();
        middleName();
        lastName();
        course();
        email();
        saveButton();
        search();
    }

    public void firstName() {
        setLayout(null);
        setOpaque(false);

        fnlabel.setText("First Name:");
        fnlabel.setFont(new Font("Figtree", Font.PLAIN,16));
        fnlabel.setBounds(30,50,100,25);
        fninputField.setBounds(150,50,275,25);

        add(fnlabel);
        add(fninputField);

    }

    public void middleName() {
        setLayout(null);
        setOpaque(false);

        mnlabel.setText("Middle Name:");
        mnlabel.setFont(new Font("Figtree", Font.PLAIN,16));
        mnlabel.setBounds(30,100,100,25);
        mninputField.setBounds(150,100,275,25);

        add(mnlabel);
        add(mninputField);
    }

    public void lastName() {
        setLayout(null);
        setOpaque(false);

        lnlabel.setText("Last Name:");
        lnlabel.setFont(new Font("Figtree", Font.PLAIN,16));
        lnlabel.setBounds(30,150,100,25);
        lninputField.setBounds(150,150,275,25);

        add(lnlabel);
        add(lninputField);
    }

    public void course() {
        setLayout(null);
        setOpaque(false);

        clabel.setText("Course:");
        clabel.setFont(new Font("Figtree", Font.PLAIN,16));
        clabel.setBounds(30,200,100,25);

        courseDropdown.setBounds(150,200,275,25);
        courseDropdown.setFont(new Font("Figtree", Font.PLAIN,14));

        add(clabel);
        add(courseDropdown);

    }

    public void email() {
        setLayout(null);
        setOpaque(false);

        emlabel.setText("Email:");
        emlabel.setFont(new Font("Figtree", Font.PLAIN,16));
        emlabel.setBounds(30,250,100,25);
        eminputField.setBounds(150,250,275,25);

        add(emlabel);
        add(eminputField);
    }

    public void search() {
        setLayout(null);
        setOpaque(false);

        searchBox.setBounds(320,65,275,30);
        searchBox.setFont(new Font("Figtree", Font.PLAIN,14));
        searchBtn.setText("SEARCH");
        searchBtn.setFont(new Font("Figtree", Font.BOLD,12));
        searchBtn.setBounds(600,65,100,25);

        searchBtn.setForeground(new Color(247, 254, 214));

        searchBtn.addActionListener(this);

        add(searchBox);
        add(searchBtn);
    }

    public void saveButton() {
        setLayout(null);
        setOpaque(false);

        save.setText("SAVE TO DATABASE");
        save.setFont(new Font("Figtree", Font.BOLD,24));
        save.setBounds(30,320,400,40);
        save.setBackground(new Color(137, 157, 106));
        save.setForeground(new Color(247, 254, 214));
        save.addActionListener(this);

        add(save);
    }

    public void clearFields() {
        fninputField.setText("");
        mninputField.setText("");
        lninputField.setText("");
        eminputField.setText("");
        courseDropdown.setSelectedIndex(0);
    }

    private boolean emailValidation(JTextField email) {
        if (email == null) {
            return false;
        }

        String text = email.getText().trim();
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        return text.matches(emailRegex);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedCourse = (String) courseDropdown.getSelectedItem();

        if (e.getSource() == save) {
            if (fninputField.getText().isEmpty() || mninputField.getText().isEmpty() || lninputField.getText().isEmpty() || courseDropdown.getSelectedItem() == "-- Select Course --" || eminputField.getText().isEmpty() || !emailValidation(eminputField)) {
                JOptionPane.showMessageDialog(null, "Must Contain Input!", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                controller.setData(lninputField.getText(), fninputField.getText(), mninputField.getText(), selectedCourse, eminputField.getText());

                System.out.println("Saved!");
                th.RefreshTable();
                clearFields();
            }

        } else if (e.getSource() == searchBtn) {
            String Text = searchBox.getText().trim();
            Search s = new Search();
            searchBox.setText("");
            s.searching(Text);
            if (th != null) {
                th.setSearchModel();
            }
        }
    }
}
