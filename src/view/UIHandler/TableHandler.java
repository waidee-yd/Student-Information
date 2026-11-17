package view.UIHandler;

import model.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

public class TableHandler extends JPanel {

    public TableHandler() {
        setLayout(null);
        setOpaque(false);

        DefaultTableModel model = Table.createModel();

        JTable dataTable = new JTable(model);

        dataTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        dataTable.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBounds(0,0,664,515);
        scrollPane.getViewport().setBackground(new Color(249,240,209));
        scrollPane.setBackground(new Color(249,240,209));

        dataTable.setBackground(new Color(249, 240, 209));
        dataTable.setForeground(new Color(60, 42, 33));
        dataTable.setGridColor(new Color(221, 210, 177));

        JTableHeader header = dataTable.getTableHeader();
        header.setBackground(new Color(221, 210, 177));
        header.setForeground(new Color(60, 42, 33));
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));

        dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < dataTable.getColumnCount(); i++) {
            TableColumn column = dataTable.getColumnModel().getColumn(i);
            int prefWidth = 100;

            Component comp = header.getDefaultRenderer().getTableCellRendererComponent(dataTable, column.getHeaderValue(), false, false, 0, i);
            prefWidth = Math.max(prefWidth, comp.getPreferredSize().width + 20);

            for (int j = 0; j < dataTable.getRowCount(); j++) {
                Component cellComp = dataTable.getCellRenderer(j,i).getTableCellRendererComponent(dataTable, dataTable.getValueAt(j,i), false, false, j, i);
                prefWidth = Math.max(prefWidth, cellComp.getPreferredSize().width + 20);
            }

            column.setPreferredWidth(prefWidth);

        }

        add(scrollPane);
    }
}
