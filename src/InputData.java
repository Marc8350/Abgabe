import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Diese Klasse speichert die Daten aus dem in fo.csv File der die Rohdaten
 * über die einzelnen Produkte aus dem Onlineshop enthalten soll, in einer
 * ArrayList mit ListElement Objekten.
 */
public class InputData {
    private  ArrayList<ListElement> product_list = new ArrayList<ListElement>();
    public  String[] column_names_AlternativenTable;
    public String[] column_names_InformationsTable;
    public Object[][] data_Alternativen;
    public  Object[] longValues_AlternativenTable;
    public  Object[] longValues_InformationsTable;
    public  void readCSVinput() {
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("infos.csv"));
            while ((line = bufferedReader.readLine()) != null){
                Object[] content = line.split(",");
                String product_name = (String) content[0];
                String description = (String) content[2];
                int price = Integer.valueOf((String) content[1]);
                product_list.add(new ListElement(product_name,description,price));
            }
            //ordnen der productliste nach dem Alphabet
            product_list.sort(ListElement.lexorder);

        } catch (IOException e){
            System.out.println("Fehlerhafte CSV Datei");
        }
    }
    public Object[][] create_data_Inforamtionsbereich(){
        Object[][] data = new Object[product_list.size()][3];
        for(int i = 0; i<product_list.size(); i++){
            data[i] = new String[]{product_list.get(i).getProduct_name(),product_list.get(i).getDescription(),String.valueOf(product_list.get(i).getPrice())};
        }
        return data;
    }
    private Object[] create_long_values(){
        String[] names = new String[product_list.size()];
        String[] descriptions = new String[product_list.size()];
        String[] prices = new String[product_list.size()];
        int index = 0;
        for(ListElement i : product_list){
            names[index] = i.getProduct_name();
            descriptions[index] = i.getDescription();
            prices[index] = String.valueOf(i.getPrice());
            index++;
        }
        return new Object[]{getlongest(names),getlongest(descriptions),getlongest(prices)};
    }
    private String getlongest(String[] o){
        String keep_String ="";
        int keep_int = 0;
        for(String i : o){
            if(i.length()>= keep_int){
                keep_int = i.length();
                keep_String = i;
            }
        }
        return keep_String;
    }
    private HashMap<String, ArrayList<ListElement>> create_Alternativen_Data_asMap(){
        HashMap<String, ArrayList<ListElement>> SelectionTable = new HashMap<>();
        SelectionTable.put("Fahrzeug",new ArrayList<ListElement>() );
        SelectionTable.put("Motor", new ArrayList<ListElement>());
        SelectionTable.put("Reifen", new ArrayList<ListElement>());
        SelectionTable.put("Extras", new ArrayList<ListElement>());
        SelectionTable.get("Fahrzeug").add(this.product_list.get(3));
        SelectionTable.get("Fahrzeug").add(this.product_list.get(5));
        SelectionTable.get("Motor").add(this.product_list.get(0));
        SelectionTable.get("Motor").add(this.product_list.get(2));
        SelectionTable.get("Reifen").add(this.product_list.get(4));
        SelectionTable.get("Reifen").add(this.product_list.get(6));
        SelectionTable.get("Extras").add(this.product_list.get(1));
        return SelectionTable;
    }
    private void setData_Alternativen(){
        HashMap<String, ArrayList<ListElement>> SelectionTable = create_Alternativen_Data_asMap();
        int i = 0;
        for (Map.Entry<String, ArrayList<ListElement>> entry : SelectionTable.entrySet()) {
            data_Alternativen[i][0] = entry.getKey();
            data_Alternativen[i][1] = entry.getValue().get(0).getProduct_name();
            if (entry.getValue().size() == 2)
                data_Alternativen[i][2] = entry.getValue().get(1).getProduct_name();
            else {
                data_Alternativen[i][2] = "Keine Extras";
            }
            i++;
        }
    }
    public InputData() {
        readCSVinput();
        this.column_names_AlternativenTable = new String[]{"Komponente ", "Alternative 1 ","Alternative 2 "};
        this.longValues_AlternativenTable = new Object[4];
        this.data_Alternativen = new Object[4][3];
        this.column_names_InformationsTable = new String[]{"Bezeichnung", "Preis", "Beschreibung"};
        setData_Alternativen();
    }
}
