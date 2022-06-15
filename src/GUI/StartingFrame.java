package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartingFrame extends JFrame implements ActionListener{
    private JButton Start;
    private JTextField FieldForRows;
    private JTextField FieldForColumns;
    private JTextField FieldForNumberOfTrees;

    public StartingFrame() {
        super("cos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setLocation(50, 50);
        setLayout(new FlowLayout());

        Start = new JButton("START");
        Start.addActionListener((ActionListener) this);

        FieldForColumns = new JTextField("Liczba kolumn");
        FieldForColumns.setEditable(true);

        FieldForRows = new JTextField("Liczba wierszy");
        FieldForRows.setEditable(true);

        FieldForNumberOfTrees = new JTextField("Liczba drzew na start");
        FieldForNumberOfTrees.setEditable(true);

        add(Start);
        add(FieldForRows);
        add(FieldForColumns);
        add(FieldForNumberOfTrees);
        setVisible(true);
    }

    public static boolean isNumeric(String str) {
        if (str.isBlank()) {return false;}
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (Start.equals(source)) {
            if(isNumeric(FieldForRows.getText())&&isNumeric(FieldForColumns.getText())&&isNumeric(FieldForRows.getText())&&Integer.parseInt(FieldForRows.getText())*Integer.parseInt(FieldForColumns.getText())>=Integer.parseInt(FieldForNumberOfTrees.getText())) {
                int Rows = Integer.parseInt(FieldForRows.getText());
                int Columns = Integer.parseInt(FieldForColumns.getText());
                int Trees = Integer.parseInt(FieldForNumberOfTrees.getText());
                try {
                    new Forest(Rows, Columns, Trees);
                    this.dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
