package net.rendicahya.swing.table;

public class DefaultTableModel extends javax.swing.table.DefaultTableModel {

    private final int COLUMN_NOT_FOUND = -1;

    public DefaultTableModel(String... columnNames) {
        super(null, columnNames);
    }

    @Override
    public void addRow(Object... rowData) {
        super.addRow(rowData);
    }

    public void removeAllRows() {
        while (getRowCount() > 0) {
            removeRow(0);
        }
    }

    /**
     * Mencari urutan kolom tabel berdasarkan nama (judul) kolom.
     *
     * @param columnTitle judul kolom yg akan dicari
     * @return urutan kolom jika kolom ditemukan -1 else
     */
    private int getColumnIndex(String columnTitle) {
        final int columnCount = getColumnCount();

        for (int column = 0; column < columnCount; column++) {
            if (getColumnName(column).equals(columnTitle)) {
                return column;
            }
        }

        return COLUMN_NOT_FOUND;
    }

    public Object getValueAt(int row, String columnTitle) {
        int column = getColumnIndex(columnTitle);

        return column == COLUMN_NOT_FOUND ? null : getValueAt(row, column);
    }

    public void setValueAt(Object aValue, int row, String columnTitle) {
        int column = getColumnIndex(columnTitle);

        if (column != COLUMN_NOT_FOUND) {
            setValueAt(aValue, row, column);
        }
    }
}