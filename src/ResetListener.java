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
        JTable target = this.view.AlternativenTable.getTable();
        for(int index1 = 1; index1 <3; index1++){
            for(int index2 = 0; index2 < 4; index2++){
                target.getModel().setValueAt(this.data.data_Alternativen[index1-1][index2], index1, index1);
            }
        }
    }
}
