import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Table extends JPanel{
    private String[] columnNames;
    private Object[][] data;
    private Object[] longValues;
    private JTable table;
    JTextField textField;
    public Table(String[] columnNames, Object[][] data, Object[] longValues){
        super(new GridLayout(1,0));
        this.columnNames = columnNames;
        this.data = data;
        this.longValues = longValues;
        this.table = new JTable(new SelectionTableModel(columnNames,data,longValues));
        table.setPreferredScrollableViewportSize(new Dimension(500,70));
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(false);
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Set up column sizes.
        initColumnSizes(table);


        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    public JTable getTable() {
        return table;
    }

    public void fireChange(){
        for(int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++){
                table.setValueAt(data[i][j], i, j);
            }
        }
    }
    private void initColumnSizes(JTable table) {
        SelectionTableModel model = (SelectionTableModel) table.getModel();
        TableColumn column = null;
        Component comp = null;
        int headerWidth = 0;
        int cellWidth = 0;
        Object[] longValues = model.longValues;
        TableCellRenderer headerRenderer =
                table.getTableHeader().getDefaultRenderer();

        for (int i = 0; i < this.columnNames.length; i++) {
            column = table.getColumnModel().getColumn(i);

            comp = headerRenderer.getTableCellRendererComponent(
                    null, column.getHeaderValue(),
                    false, false, 0, 0);
            headerWidth = comp.getPreferredSize().width;
            comp = table.getDefaultRenderer(model.getColumnClass(i)).
                    getTableCellRendererComponent(
                            table, longValues[i],
                            false, false, 0, i);
            cellWidth = comp.getPreferredSize().width;


            column.setPreferredWidth(Math.max(headerWidth, cellWidth));
        }
    }
}
