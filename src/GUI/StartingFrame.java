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
        setVisible(true);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (Start.equals(source)) {
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
