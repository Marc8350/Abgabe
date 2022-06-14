import javax.swing.*;

public class ViewComposer extends JPanel {
    private JPanel panel1;
    private Table Alternativen;
    private Table Warenkorb;
    private Table Informationsansicht;
    private JTextField maximalerPreisTextField;
    private JButton checkoutButton;

    public static void composeView(){
        JFrame shop = new JFrame("Autoteileshop");
        shop.setTitle("Autoteile Shop");
        InputData datahouse = new InputData();
        shop.setBounds(100, 100, 1277, 644);
        shop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Table AlternativenTable = new Table(datahouse.column_names_AlternativenTable, datahouse.data_Alternativen,datahouse.longValues_AlternativenTable);
        shop.setContentPane(AlternativenTable);
        shop.pack();
        shop.setVisible(true);
    }
}
