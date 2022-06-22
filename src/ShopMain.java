import Model.InputData;
import View.ViewComposer;

import java.io.IOException;
public class ShopMain {
    public static void main(String[] args) throws IOException {
        InputData data = new InputData();
        ViewComposer test = new ViewComposer(data);
        test.setController();
        test.setVisible(true);
    }
}
