package GUI;

import Program.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Panel extends JPanel {
    int Rows;
    int Columns;
    Board board;
    JButton[][] CellsTable;
    JButton cell;
    ImageIcon dzewo;
    ImageIcon firek;
    ImageIcon burek;

    public Panel(int Rows, int Columns, int Trees) throws IOException {
        dzewo = new ImageIcon("resource/icons/Drzewo.png");
        firek = new ImageIcon("resource/icons/Fire.png");
        burek = new ImageIcon("resource/icons/Burned.png");


        this.Rows = Rows;
        this.Columns = Columns;
        board = new Board();
        board.generator(Rows, Columns, Trees);
        CellsTable = new JButton[Rows][Columns];
        setLayout(new GridLayout(Rows, Columns));
        for (int row = 0; row<Rows; row++){
            for(int column = 0; column<Columns; column++){
                cell = new JButton();
                cell.setPreferredSize(new Dimension(20,20));
                CellsTable[row][column] = cell;
                add(cell);
            }
        }
        refresh();
    }

    public void NextState(float ProL, float ProT){
        board.Update(ProL, ProT);
        refresh();
        repaint();
    }

    public void refresh(){
        for(int x = 0; x<Rows; x++){
            for(int y = 0; y<Columns; y++){
                String ActualValue = board.Board[x][y].getState();
                if(ActualValue == "Tree"){
                    CellsTable[x][y].setIcon(dzewo);
                }
                else if(ActualValue == "Burning"){
                    CellsTable[x][y].setIcon(firek);
                }
                else{
                    CellsTable[x][y].setIcon(burek);
                }
            }
        }
    }
}
