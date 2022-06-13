package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Forest extends JFrame implements ActionListener {
    private Panel pl;
    private JTextField ProL;
    private JTextField ProT;
    private JButton Next;
    private JButton Tick;

    public Forest(int Rows, int Columns, int Trees) throws IOException {
        super("cos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(250, 250);
        setLocation(50, 50);
        setLayout(new FlowLayout());

        pl = new Panel(Rows, Columns, Trees);
        add(pl);

        ProL = new JTextField("Prawdopodobienśtwo uderzenie pioruna");
        ProL.setEditable(true);
        add(ProL);

        ProT = new JTextField("Prawdopodobienśtwo urosniecia drzewa");
        ProT.setEditable(true);
        add(ProT);

        Next = new JButton("Next");
        Next.addActionListener((ActionListener) this);
        add(Next);

        Tick = new JButton("Next2");
        Tick.addActionListener((ActionListener) this);
        add(Tick);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (Next.equals(source)) {
            float ProL1 = Float.parseFloat(ProL.getText());
            float ProT1 = Float.parseFloat(ProT.getText());
            pl.NextState(ProL1, ProT1);
        }
        else if(Tick.equals(source)){
            float ProL1 = Float.parseFloat(ProL.getText());
            float ProT1 = Float.parseFloat(ProT.getText());
            while(true){
                try {
                    pl.NextState2(ProL1, ProT1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
