package GUI;

import org.w3c.dom.events.Event;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.EventListener;
import java.util.concurrent.TimeUnit;

public class Forest extends JFrame implements ActionListener {
    Timer tm = new Timer(250, (ActionListener) this);
    private Panel pl;
    private JTextField ProL;
    private JTextField ProT;
    private JButton Next;
    private JButton Tick;
    private JButton Stop;
    private JTextField Counter;
    private Boolean S = false;
    Integer[] choices = {1000, 750, 500, 250, 100};
    private JComboBox<Integer> time = new JComboBox<Integer>(choices);


    public Forest(int Rows, int Columns, int Trees) throws IOException {
        super("cos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 500);
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

        add(time);

        Counter = new JTextField("0",4);
        Counter.setEditable(false);
        add(Counter);

        Next = new JButton("Next");
        Next.addActionListener((ActionListener) this);
        add(Next);

        Tick = new JButton("Start");
        Tick.addActionListener((ActionListener) this);
        add(Tick);

        Stop = new JButton("Stop");
        Stop.addActionListener((ActionListener) this);
        add(Stop);

        tm.start();
    }

    public static boolean isNumeric(String str) {
        if (str.isBlank()) {return false;}
        try {
            Float.parseFloat(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(Stop.equals(source)){
            S = false;
        }
        else if(Tick.equals(source)){
            S = true;
            tm.setDelay(choices[time.getSelectedIndex()]);
        }
        if(S){
            source = Next;
        }
        if (Next.equals(source)) {
            if(isNumeric(ProL.getText())&&isNumeric(ProT.getText())){
                float ProL1 = Float.parseFloat(ProL.getText());
                float ProT1 = Float.parseFloat(ProT.getText());
                pl.NextState(ProL1, ProT1);
                Counter.setText(String.valueOf(Integer.parseInt(Counter.getText())+1));
                repaint();
            }
        }
    }
}
