import javax.swing.table.AbstractTableModel;

public class SelectionTableModel extends AbstractTableModel {

    private String [] columnNames;
    private Object[][] data;

    public SelectionTableModel(String[] columnNames, Object[][] data, Object[] longValues) {
        this.columnNames = columnNames;
        this.data = data;
        this.longValues = longValues;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
    public void setValueAt(Object value, int row, int col){
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    public void updateValues(InputData newdata){
        for(int index1 = 0; index1 <2; index1++){
            for(int index2 = 0; index2 < 4; index2++){
                this.data[index1][index2] = newdata.data_Alternativen[index1][index2];
            }
        }
    }
    public final Object[] longValues;
    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return false;
    }
}
