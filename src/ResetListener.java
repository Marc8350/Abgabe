import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ResetListener implements MouseListener {
    InputData data;
    Table info, auswahl, warenkorb;
    public ResetListener(InputData data, Table info, Table auswahl, Table warenkorb){
        super();
        this.data = data;
        this.info = info;
        this.auswahl = auswahl;
        this.warenkorb = warenkorb;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Test");
        data.resetSelection();

        auswahl.fireChange();
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
