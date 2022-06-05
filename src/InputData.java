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
        } catch (IOException e){
            System.out.println("Fehlerhafte CSV Datei");
        }

    }

}
