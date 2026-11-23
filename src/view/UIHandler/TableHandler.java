package view.UIHandler;

import controller.Search;
import controller.TableController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

public class TableHandler extends JPanel {

    DefaultTableModel model = TableController.createModel();
    public JTable dataTable = new JTable(model);

    public JScrollPane scrollPane = new JScrollPane(dataTable);
    public JTableHeader header = dataTable.getTableHeader();

    public TableHandler() {
        setLayout(null);
        setOpaque(false);

        dataTable.getTableHeader().setResizingAllowed(false);
        dataTable.getTableHeader().setReorderingAllowed(false);
        if (dataTable.getRowCount() == 0) {
            dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        } else {
            dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }

        dataTable.setFont(new Font("Figtree", Font.PLAIN, 12));
        dataTable.setRowHeight(25);

        scrollPane.setBounds(0,0,664,515);
        scrollPane.getViewport().setOpaque(true);

        header.setFont(new Font("Figtree", Font.BOLD, 14));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));

        adjustColumnWidth();
        add(scrollPane);
    }

    public void adjustColumnWidth() {
        JTableHeader header = dataTable.getTableHeader();
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
    }

    public void RefreshTable() {
        dataTable.setModel(TableController.createModel());
        adjustColumnWidth();
    }

    public void setSearchModel() {
        dataTable.setModel(Search.searchModel());

        if (dataTable.getRowCount() == 0) {
            dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        } else {
            dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
        adjustColumnWidth();
    }

}
