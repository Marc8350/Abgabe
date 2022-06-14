import java.util.Comparator;

/**
 * Die Klasse ListElement dient dazu einzelne Produkte als Objekte ab zu speichern.
 */
public class ListElement implements Comparable<ListElement>{
    private String product_name;
    private String description;
    private int price;

    /**
     *
     * @param product_name
     * @param description
     * @param price
     */
    public ListElement(String product_name, String description, int price){
        this.product_name = product_name;
        this.description = description;
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(ListElement o) {
        return this.getProduct_name().compareTo(o.getProduct_name());
    }
    public static Comparator<ListElement> lexorder = new Comparator<ListElement>() {
        @Override
        public int compare(ListElement o1, ListElement o2) {
            return o1.getProduct_name().compareTo(o2.getProduct_name());
        }
    };
}

