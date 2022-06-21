import java.io.IOException;
public class ShopMain {
    public static void main(String[] args) throws IOException {
        InputData data = new InputData();
        ViewComposer test = new ViewComposer(data);
        Control controller = new Control(test, data);
        test.setController();
        test.setVisible(true);
        //ViewComposer.composeView();
    }
}
