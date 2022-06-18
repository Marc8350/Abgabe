import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectionTableListener implements MouseListener {
    InputData data;

    public SelectionTableListener(InputData data) {
        super();
        this.data = data;
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

