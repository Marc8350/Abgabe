import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewComposer extends JFrame {
    private JTextField maximalerPreisTextField;
    private JButton auswahlZurücksetzenButton, checkoutButton;
    private JLabel Warenkorb, Auswahlbereich, Informationsbereich, MaxPreis;
    public Table Informationstable, Warenkorbtable, AlternativenTable;
    public Control controller;
    public ViewComposer(InputData datahouse) {
        super("Autoteileshop");
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        setBounds(100, 100, 1277, 644);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        MaxPreis = new JLabel("Bitte hier Maximalen Preis einegeben");
        layout.setConstraints(MaxPreis, constraints);
        add(MaxPreis);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        maximalerPreisTextField = new JTextField();
        layout.setConstraints(maximalerPreisTextField, constraints);
        add(maximalerPreisTextField);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        Warenkorb = new JLabel("Warenkorb");
        layout.setConstraints(Warenkorb, constraints);
        add(Warenkorb);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        maximalerPreisTextField = new JTextField("Maximalen Preis eingeben");
        layout.setConstraints(maximalerPreisTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        AlternativenTable = new Table(datahouse.column_names_AlternativenTable, datahouse.data_Alternativen, datahouse.longValues_AlternativenTable);
        layout.setConstraints(AlternativenTable, constraints);
        add(AlternativenTable);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        Warenkorbtable = new Table(datahouse.column_names_Warenkorb, datahouse.create_data_Warenkorb(), datahouse.longValues_Warenkorb);
        layout.setConstraints(Warenkorbtable, constraints);
        add(Warenkorbtable);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        Informationsbereich = new JLabel("Informationsbereich");
        layout.setConstraints(Informationsbereich, constraints);
        add(Informationsbereich);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        Informationstable = new Table(datahouse.column_names_InformationsTable, datahouse.create_data_Inforamtionsbereich(datahouse.product_list.get(1)), datahouse.longValues_InformationsTable);
        layout.setConstraints(Informationstable, constraints);
        add(Informationstable);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        checkoutButton = new JButton("proceed to Checkout");
        layout.setConstraints(checkoutButton, constraints);

        add(checkoutButton);
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        auswahlZurücksetzenButton = new JButton("Auswahl zurücksetzen");
        layout.setConstraints(auswahlZurücksetzenButton, constraints);
        add(auswahlZurücksetzenButton);

    }
    public void setController(Control c){
        this.controller = c;
        System.out.println(this.AlternativenTable.getTable());
        this.AlternativenTable.getTable().addMouseListener(new SelectionTableListener(this.controller.datahouse,this));
        this.auswahlZurücksetzenButton.addActionListener(new ResetListener(c.datahouse, this));
    }


}
