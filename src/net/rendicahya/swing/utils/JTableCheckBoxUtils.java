package net.rendicahya.swing.utils;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class JTableCheckBoxUtils {

    public static boolean someCheckBoxIsTicked(JTable table, String columnName) {
        int column = JTableUtils.getColumnIndex(table, columnName);

        return someCheckBoxIsTicked(table, column);
    }

    public static boolean someCheckBoxIsTicked(JTable table, int column) {
        TableModel model = table.getModel();
        int rowCount = model.getRowCount();

        for (int row = 0; row < rowCount; row++) {
            boolean ticked = Boolean.parseBoolean(String.valueOf(model.getValueAt(row, column)));

            if (ticked) {
                return true;
            }
        }

        return false;
    }

    public static int countTickedCheckBox(JTable table, String columnName) {
        int column = JTableUtils.getColumnIndex(table, columnName);

        return countTickedCheckBox(table, column);
    }

    public static int countTickedCheckBox(JTable table, int column) {
        TableModel model = table.getModel();
        int rowCount = model.getRowCount();
        int count = 0;

        for (int row = 0; row < rowCount; row++) {
            boolean ticked = Boolean.parseBoolean(String.valueOf(model.getValueAt(row, column)));

            if (ticked) {
                count++;
            }
        }

        return count;
    }
}
