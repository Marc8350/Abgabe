import javax.swing.*;
public class ViewComposer extends JFrame {
    private SelectionView selectionView;
    public ViewComposer(){
        selectionView = new SelectionView();
        add(selectionView);
    }
}
