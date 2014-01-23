package net.rendicahya.swing.table;

import java.util.HashMap;
import javax.swing.JTable;
import net.rendicahya.commons.utils.RcStringUtils;

public class TableRowData {

    private final HashMap<String, Object> map = new HashMap<>();

    public static TableRowData getRowData(JTable table, int row) {
        return new TableRowData(table, row);
    }

    private TableRowData(JTable table, int row) {
        int columnCount = table.getColumnCount();

        for (int column = 0; column < columnCount; column++) {
            map.put(table.getColumnName(column), table.getValueAt(row, column));
        }
    }

    public Object getObject(String columnName) {
        return map.get(columnName);
    }

    public String getString(String columnName) {
        return String.valueOf(getObject(columnName));
    }

    public boolean getBoolean(String columnName) {
        return Boolean.parseBoolean(getString(columnName));
    }

    public int getInt(String columnName) {
        return RcStringUtils.extractInt(getString(columnName));
    }

    public long getLong(String columnName) {
        return Long.parseLong(getString(columnName));
    }

    public float getFloat(String columnName) {
        return RcStringUtils.extractFloat(getString(columnName));
    }

    public double getDouble(String columnName) {
        return Double.parseDouble(getString(columnName));
    }
}
