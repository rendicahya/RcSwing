package net.rendicahya.swing.utils;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.rendicahya.commons.utils.RcStringUtils;

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

    public static int parseIntValueAt(JTable table, int row, String columnTitle) {
        return RcStringUtils.extractInt(getStringValueAt(table, row, columnTitle));
    }

    public static String getStringValueAt(JTable table, int row, String columnTitle) {
        return String.valueOf(getValueAt(table, row, columnTitle));
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

    public static void setModelValueAt(JTable table, Object value, int row, int columnIndex) {
        table.getModel().setValueAt(value, row, columnIndex);
    }

    public static void setModelValueAt(JTable table, Object value, int row, String columnTitle) {
        int column = getColumnIndex(table, columnTitle);

        if (column != COLUMN_NOT_FOUND) {
            table.getModel().setValueAt(value, row, column);
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
        TableColumn column = table.getColumnModel().getColumn(columnIndex);

        column.setMaxWidth(0);
        column.setMinWidth(0);
        column.setResizable(false);
        column.setPreferredWidth(0);
    }
}
