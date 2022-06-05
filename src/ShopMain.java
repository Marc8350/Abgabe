import javax.swing.*;
import java.io.IOException;
public class ShopMain {
    public static void main(String[] args) throws IOException {
        InputData.readCSVinput();
        ViewComposer shop = new ViewComposer();
        shop.setTitle("Autoteile Shop");
        shop.setBounds(100, 100, 1277, 644);
        shop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shop.setVisible(true);
    }
}
