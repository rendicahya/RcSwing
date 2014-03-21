package net.rendicahya.swing.utils;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.rendicahya.commons.utils.RcStringUtils;
import org.jsoup.Jsoup;

public class JTableUtils {

    private static final int COLUMN_NOT_FOUND = -1;

    private JTableUtils() {
    }

    public static int getRowIndex(JTable table, int column, String value) {
        int rowCount = table.getModel().getRowCount();

        for (int row = 0; row < rowCount; row++) {
            if (table.getModel().getValueAt(row, column).equals(value)) {
                return row;
            }
        }

        return -1;
    }

    public static int getRowIndexStripHtmlTags(JTable table, int column, String value) {
        int rowCount = table.getModel().getRowCount();

        for (int row = 0; row < rowCount; row++) {
            if (Jsoup.parse(String.valueOf(table.getModel().getValueAt(row, column))).text().equals(value)) {
                return row;
            }
        }

        return -1;
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

    public static int getColumnIndexStripHtmlTags(JTable table, String columnTitle) {
        int columnCount = table.getColumnCount();

        for (int column = 0; column < columnCount; column++) {
            if (Jsoup.parse(table.getColumnName(column)).text().equalsIgnoreCase(columnTitle)) {
                return column;
            }
        }

        return COLUMN_NOT_FOUND;
    }

    public static int parseIntValueAt(JTable table, String columnTitle) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            return -1;
        }

        return parseIntValueAt(table, selectedRow, columnTitle);
    }

    public static int parseIntValueAt(JTable table, int row, String columnTitle) {
        return RcStringUtils.extractInt(getStringValueAt(table, row, columnTitle));
    }

    public static String getStringValueAt(JTable table, int columnIndex) {
        return getStringValueAt(table, table.getSelectedRow(), columnIndex);
    }

    public static String getStringValueAt(JTable table, int row, int columnIndex) {
        return String.valueOf(table.getValueAt(row, columnIndex));
    }

    public static String getStringValueAt(JTable table, String columnTitle) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            return null;
        }

        return getStringValueAt(table, selectedRow, columnTitle);
    }

    public static String getStringValueAt(JTable table, int row, String columnTitle) {
        return String.valueOf(getValueAt(table, row, columnTitle));
    }

    public static Object getValueAt(JTable table, String columnTitle) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            return null;
        }

        return getValueAt(table, selectedRow, columnTitle);
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

    public static void setIncrementalColumn(JTable table, Class<?> klass) {
        table.setDefaultRenderer(klass, new IncrementalValueColumn());
    }

    private static class IncrementalValueColumn extends JLabel implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object color,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText(String.valueOf(row + 1));

            return this;
        }
    }

    public static void hideColumn(JTable table, int columnIndex) {
        TableColumn column = table.getColumnModel().getColumn(columnIndex);

        column.setMaxWidth(0);
        column.setMinWidth(0);
        column.setResizable(false);
        column.setPreferredWidth(0);
    }

    public static void moveSelectionDown(JTable table) {
        int selectedRow = table.getSelectedRow();
        int selectedRowCount = table.getSelectedRowCount();
        int rowCount = table.getRowCount();
        int targetRow;

        if (rowCount == 0) {
            return;
        } else if (rowCount == 1) {
            targetRow = 0;
        } else {
            int bottomRow = selectedRowCount == 1
                    ? selectedRow
                    : table.getSelectionModel().getMaxSelectionIndex();

            if (bottomRow < rowCount - 1) {
                targetRow = bottomRow + 1;
            } else {
                targetRow = bottomRow;
            }
        }

        table.getSelectionModel().setSelectionInterval(targetRow, targetRow);
    }
}
