package net.rendicahya.swing.utils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class JTableUtils {

    private static final int COLUMN_NOT_FOUND = -1;

    private JTableUtils() {
    }

    public static void setColumnWidth(JTable table, int... width) {
        TableColumnModel columnModel = table.getColumnModel();
        int length = width.length;
        int columnCount = table.getColumnCount();

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < length && i < columnCount; i++) {
            columnModel.getColumn(i).setPreferredWidth(width[i]);
        }
    }

    public static void addRow(JTable table, Object... data) {
        ((DefaultTableModel) table.getModel()).addRow(data);
    }

    public static void removeRow(JTable table, int row) {
        ((DefaultTableModel) table.getModel()).removeRow(row);
    }

    public static int getColumnIndex(JTable table, String columnTitle) {
        int columnCount = table.getColumnCount();

        for (int column = 0; column < columnCount; column++) {
            if (table.getColumnName(column).equalsIgnoreCase(columnTitle)) {
                return column;
            }
        }

        return COLUMN_NOT_FOUND;
    }

    public static Object getValueAt(JTable table, int row, String columnTitle) {
        int column = getColumnIndex(table, columnTitle);

        return column == COLUMN_NOT_FOUND ? null : table.getValueAt(row, column);
    }

    public static void setValueAt(JTable table, Object value, int row, String columnTitle) {
        int column = getColumnIndex(table, columnTitle);

        if (column != COLUMN_NOT_FOUND) {
            table.setValueAt(value, row, column);
        }
    }

    public static void removeAllRows(JTable... tables) {
        for (JTable table : tables) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
        }
    }

    public static void hideColumn(JTable table, int columnIndex) {
        TableColumn column = table.getColumn(columnIndex);

        column.setMaxWidth(0);
        column.setMinWidth(0);
        column.setPreferredWidth(0);
    }
}
