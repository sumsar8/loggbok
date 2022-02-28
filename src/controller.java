import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;


public class controller {
    private model model;
    private view view;
    private PrintWriter PW;
    private Scanner scanner;

    public static void main(String args[]) {
        controller c = new controller();
    }

    public controller() {
        view = new view();
        model = new model();

        Action execute = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                model.saveInput(view.getTextField1().getText(),view.getTextField2().getText());
                view.getTextArea1().setText(model.getList());
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

        view.Savebutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser FileChoser = new JFileChooser("");
                FileChoser.showSaveDialog(null);
                File outputfile = FileChoser.getSelectedFile();

                try {
                    PW = new PrintWriter(String.valueOf(outputfile));
                    PW.println(model.getList());
                    PW.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });
        view.Loadbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser FileChoser = new JFileChooser("");
                FileChoser.showOpenDialog(null);
                File outputfile = FileChoser.getSelectedFile();

                try {
                    scanner = new Scanner(new File(String.valueOf(outputfile)));
                    while (scanner.hasNext()){
                        String NextLine = scanner.nextLine();
                        model.saveInput(NextLine,view.getTextField2().getText());
                    }
                    view.getTextArea1().setText(model.getList());

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}