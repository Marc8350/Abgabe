import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

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
        Object[][] items = data.create_data_Warenkorb();
        for(int index = 0; index < items.length;index++){
            view.Warenkorbtable.getTable().getModel().setValueAt(items[index][0], index, 0);
            view.Warenkorbtable.getTable().getModel().setValueAt(items[index][1], index, 1);
        }
        ListElement item = data.latestselectet.get(data.latestselectet.size()-1);
        this.view.Informationstable.getTable().getModel().setValueAt(item.getProduct_name(), 0,0 );
        this.view.Informationstable.getTable().getModel().setValueAt(item.getPrice(), 0,1 );
        this.view.Informationstable.getTable().getModel().setValueAt(item.getDescription(), 0,2 );

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

