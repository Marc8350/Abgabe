import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Preislistener implements ActionListener {
    private ViewComposer view;
    private InputData data;
    public Preislistener(ViewComposer view, InputData data) {
        this.view = view;
        this.data = data;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int t = 0;
        String content = this.view.maximalerPreisTextField.getText();
        try {
            t = Integer.parseInt(content);
            System.out.println(t);
        } catch (NumberFormatException pi){
            this.view.maximalerPreisTextField.setBackground(Color.red);
        }

    }
}
