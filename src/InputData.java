import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Diese Klasse speichert die Daten aus dem in fo.csv File der die Rohdaten
 * über die einzelnen Produkte aus dem Onlineshop enthalten soll, in einer
 * ArrayList mit ListElement Objekten.
 */
public class InputData {
    public ArrayList<ListElement> product_list = new ArrayList<ListElement>();
    public  String[] column_names_AlternativenTable;
    public String[] column_names_InformationsTable;
    public String[] column_names_Warenkorb;
    public Object[][] data_Alternativen;
    public  Object[] longValues_AlternativenTable;
    public  Object[] longValues_InformationsTable;
    public Object[] longValues_Warenkorb;
    public Object [][] data_Warenkorb;
    public ArrayList<ListElement> latestselectet = new ArrayList<ListElement>();
    public int upperlimit, currentvalue;
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
            product_list.add(new ListElement("Keine Extras", " ", 0));
            //ordnen der productliste nach dem Alphabet
            product_list.sort(ListElement.lexorder);

        } catch (IOException e){
            System.out.println("Fehlerhafte CSV Datei");
        }
    }
    public Object[][] create_data_Inforamtionsbereich(ListElement latestViewedProduct){
        Object[][] data = new Object[][]{new Object[]{latestViewedProduct.getProduct_name(),latestViewedProduct.getPrice(),latestViewedProduct.getDescription()}};
        return data;
    }
    public Object[][] create_data_Warenkorb(){
        product_list.sort(ListElement.lexorder);
        ArrayList<ListElement> input = new ArrayList<ListElement>();
        for(ListElement i : product_list){
            if(i.isSelected())
                input.add(i);
        }
        Object[][] data = new Object[9][2];
        int index = 0;
        for(ListElement i : input){
            data[index][0] = i.getPrice();
            data[index][1] = i.getProduct_name();
            index++;
        }
        int sum = 0;
        for(int i = 0; i <input.size(); i++){
              sum += (int) data[i][0];
        }
        this.currentvalue = sum;
        data[input.size()][0] = sum;
        data[input.size()][1] = ": Total";
        data_Warenkorb = data;
        System.out.println(currentvalue);
        return data;
    }
    private Object[] create_long_values_Information(){
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
        return new Object[]{getlongest(names),getlongest(prices),getlongest(descriptions)};
    }
    private Object[] create_long_values_Auswahl(){
        String[] names = new String[product_list.size()];
        int index = 0;
        for(ListElement i : product_list){
            names[index] = i.getProduct_name();
            index++;
        }
        return new Object[]{getlongest(names),getlongest(names),getlongest(names)};
    }
    private Object[] create_long_values_Warenkorb(){
        String[] names = new String[product_list.size()];
        int index = 0;
        for(ListElement i : product_list){
            names[index] = i.getProduct_name();
            index++;
        }
        return new Object[]{"Preise", getlongest(names)};
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
        SelectionTable.get("Fahrzeug").add(this.product_list.get(4));
        SelectionTable.get("Fahrzeug").add(this.product_list.get(6));
        SelectionTable.get("Motor").add(this.product_list.get(0));
        SelectionTable.get("Motor").add(this.product_list.get(2));
        SelectionTable.get("Reifen").add(this.product_list.get(5));
        SelectionTable.get("Reifen").add(this.product_list.get(7));
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
    public void selectItem(String bezeichner){
        product_list.get(suchen(bezeichner)).setSelected(true);
        latestselectet.add(product_list.get(suchen(bezeichner)));
    }
    public boolean isSelected(String bezeichner){
        if(product_list.get(suchen(bezeichner)).isSelected())
            return true;
        else
            return false;
    }
    public void resetSelection(){
        for(ListElement i: product_list){
            i.setSelected(false);
        }
        setData_Alternativen();

    }
    public int suchen (String bezeichenr){
        int index = 0;
        for(ListElement i : product_list){
            if (i.getProduct_name().equals(bezeichenr))
                break;
            index++;
        }
        return index;
    }
    public InputData() {
        readCSVinput();
        this.column_names_AlternativenTable = new String[]{"Komponente ", "Alternative 1 ","Alternative 2 "};
        this.longValues_AlternativenTable = create_long_values_Auswahl();
        this.data_Alternativen = new Object[4][3];
        setData_Alternativen();
        this.column_names_InformationsTable = new String[]{"Bezeichnung", "Preis", "Beschreibung"};
        this.longValues_InformationsTable = create_long_values_Information();
        this.longValues_Warenkorb = create_long_values_Warenkorb();
        this.column_names_Warenkorb = new String[]{"Preise ","Bezeichnung"};
        this.upperlimit = 1000000;
        this.currentvalue = 0;
    }
}
