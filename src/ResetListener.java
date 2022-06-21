import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ResetListener implements ActionListener {
    InputData data;
    ViewComposer view;

    public ResetListener(InputData data, ViewComposer view) {
        this.data = data;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.data.resetSelection();
        JTable alternativenTableTable = this.view.AlternativenTable.getTable();
        for(int index1 = 0; index1 <4; index1++){
            alternativenTableTable.getModel().setValueAt(this.data.data_Alternativen[index1][1], index1, 1);
            alternativenTableTable.getModel().setValueAt(this.data.data_Alternativen[index1][2], index1, 2);
        }
        Object[][] items = data.create_data_Warenkorb();
        for(int index = 0; index < items.length;index++){
            view.Warenkorbtable.getTable().getModel().setValueAt(items[index][0], index, 0);
            view.Warenkorbtable.getTable().getModel().setValueAt(items[index][1], index, 1);
        }
        this.view.Informationstable.getTable().getModel().setValueAt("", 0,0 );
        this.view.Informationstable.getTable().getModel().setValueAt("", 0,1 );
        this.view.Informationstable.getTable().getModel().setValueAt("", 0,2 );
    }
}
