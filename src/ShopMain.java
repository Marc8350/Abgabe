import javax.swing.*;
import java.io.IOException;
public class ShopMain {
    public static void main(String[] args) throws IOException {
        InputData.readCSVinput();
        ViewComposer.composeView();
    }
}
