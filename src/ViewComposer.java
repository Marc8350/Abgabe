import javax.swing.*;
import java.awt.*;

public class ViewComposer extends JPanel {
    private SelectionView selectionView;
    public static void composeView(){
        JFrame shop = new JFrame("Autoteileshop");
        shop.setTitle("Autoteile Shop");

        shop.setBounds(100, 100, 1277, 644);
        shop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SelectionView selectionView = new SelectionView();
        shop.setContentPane(selectionView);
        shop.pack();
        shop.setVisible(true);
    }
}
