package view.UIHandler;

import model.Table;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TableHandler extends JPanel {

    public TableHandler() {
        setLayout(null);
        setOpaque(false);

        JTable dataTable = new JTable(Table.createModel());

        dataTable.setFont(new Font("Segoe UI", Font.BOLD, 24));
        dataTable.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBounds(0,0,664,515);

        dataTable.setBackground(new Color(249, 240, 209));
        dataTable.setForeground(new Color(60, 42, 33));
        dataTable.setGridColor(new Color(221, 210, 177));

        JTableHeader header = dataTable.getTableHeader();
        header.setBackground(new Color(221, 210, 177));
        header.setForeground(new Color(60, 42, 33));
        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));

        add(scrollPane);
    }
}
