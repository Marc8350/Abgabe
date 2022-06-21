package Controler;

import View.ViewComposer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;

public class checkOutListener implements ActionListener {
    private final ViewComposer view;

    public checkOutListener(ViewComposer view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int returnval = view.fileChooser.showOpenDialog(view.fileChooser);
        if (returnval == JFileChooser.APPROVE_OPTION) {
            File file = new File(view.fileChooser.getCurrentDirectory(),"/exportshop.txt") ;
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                StringJoiner stringJoiner = new StringJoiner("| ");
                for (int col = 0; col < this.view.Warenkorbtable.getTable().getColumnCount(); col++) {
                    stringJoiner.add(this.view.Warenkorbtable.getTable().getColumnName(col));
                }
                bufferedWriter.write(stringJoiner.toString());
                bufferedWriter.newLine();
                for (int row = 0; row < this.view.Warenkorbtable.getTable().getRowCount(); row++) {
                    stringJoiner = new StringJoiner("  ");
                    for (int col = 0; col < this.view.Warenkorbtable.getTable().getColumnCount(); col++) {
                        Object obj = this.view.Warenkorbtable.getTable().getValueAt(row, col);
                        String value = obj == null ? "" : obj.toString();
                        stringJoiner.add(value);
                    }
                    bufferedWriter.write(stringJoiner.toString());
                    bufferedWriter.newLine();
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }
    }
}
