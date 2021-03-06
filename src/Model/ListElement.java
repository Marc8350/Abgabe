package Model;

import java.util.Comparator;

/**
 * Die Klasse Model.ListElement dient dazu einzelne Produkte als Objekte ab zu speichern.
 */
public class ListElement implements Comparable<ListElement>{
    private final String product_name;
    private final String description;
    private final int price;
    private boolean selected;

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
        this.selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
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

