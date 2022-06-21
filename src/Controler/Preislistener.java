package Controler;

import Model.InputData;
import View.ViewComposer;

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
        int upperlimit = 0;
        String content = this.view.maximalerPreisTextField.getText();
        try {
            upperlimit = Integer.parseInt(content);
            this.view.maximalerPreisTextField.setBackground(Color.white);
            data.upperlimit = upperlimit;
        } catch (NumberFormatException pi){
            this.view.maximalerPreisTextField.setBackground(Color.red);
        }

    }
}
