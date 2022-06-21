import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectionTableListener implements MouseListener {
    InputData data;
    ViewComposer view;

    public SelectionTableListener(InputData data, ViewComposer view) {
        super();
        this.data = data;
        this.view = view;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JTable target = (JTable) e.getSource();
        int row = target.getSelectedRow();
        int column = target.getSelectedColumn();
        String value = (String) target.getModel().getValueAt(row,column);
        if(!data.isSelected( value)) {
            if (column == 1) {
                target.getModel().setValueAt(" ", row, 2);
                data.selectItem(value);
            }
            if (column == 2) {
                target.getModel().setValueAt(" ", row, 1);
                data.selectItem(value);
            }
        }
        Object[][] items = data.data_Warenkorb;
        for(int index = 0; index < items.length;index++){
            view.Warenkorbtable.getTable().getModel().setValueAt(items[index][0], index, 0);
            view.Warenkorbtable.getTable().getModel().setValueAt(items[index][1], index, 1);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

