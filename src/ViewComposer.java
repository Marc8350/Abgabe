import javax.swing.*;
public class ViewComposer extends JFrame {
    private SelectionView selectionView;
    public ViewComposer(){
        JButton t = new JButton("t");
        selectionView = new SelectionView();
        add(selectionView);
    }
}
