import javax.swing.*;

public class SelectionView extends JPanel{
    String[] column_names;
    Object[][] data ;
    JTable table;
    JScrollPane pane;
    SelectionView(){
        column_names =new String[]{"Ausgewählt", "Produkt", "Beschreibung", "Preis"};
        data = new Object[InputData.getProduct_list().toArray().length][4];
        for(int i = 0; i < data.length; i++){
            data[i] = new Object[]{ false, InputData.getProduct_list().get(i).getProduct_name(), InputData.getProduct_list().get(i).getDescription(), InputData.getProduct_list().get(i).getPrice()};
        }
        table = new JTable(data,column_names);
        pane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(pane);
    }
}
