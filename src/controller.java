import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.*;

public class controller {
    private model model;
    private view view;

    public static void main(String args[]) {
        controller c = new controller();
    }

    public controller() {
        view = new view();
        model = new model();

        Action execute = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                model.saveInput(view.getTextField1().getText());
            }
        };

        JFrame frame = new JFrame("Oga");
        frame.setContentPane(view.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(700,700);
        view.getTextArea1().setEditable(false);
        view.getTextField1().requestFocus();
        view.getTextField1().getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "Activate");
        view.getTextField1().getActionMap().put("Activate", execute);

    }
}