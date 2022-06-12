import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Diese Klasse speichert die Daten aus dem info.csv File der die Rohdaten
 * über die einzelnen Produkte aus dem Onlineshop enthalten soll, in einer
 * ArrayList mit ListElement Objekten.
 */
public class InputData {
    private static ArrayList<ListElement> product_list = new ArrayList<ListElement>();
    public static ArrayList<ListElement> getProduct_list() {
        return product_list;
    }
    public static String[] column_names =new String[]{"Gewünschte Menge","Produkt        ", "Beschreibung", "Preis"};
    public static Object[][] data;
    public static Object[] longValues = new Object[4];
    public static void readCSVinput() {
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
            data = new Object[product_list.size()][3];
            for(int i = 0; i<product_list.size(); i++){
                data[i] = new String[]{"0",product_list.get(i).getProduct_name(),product_list.get(i).getDescription(),String.valueOf(product_list.get(i).getPrice())};
            }
            System.out.println("Test");
        } catch (IOException e){
            System.out.println("Fehlerhafte CSV Datei");
        }
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
        longValues = new Object[]{"100",getlongest(names),getlongest(descriptions),getlongest(prices)};
    }
    private static String getlongest(String[] o){
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



}
