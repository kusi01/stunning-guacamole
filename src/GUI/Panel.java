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

    public Panel(int Rows, int Columns, int Trees) throws IOException {
        this.Rows = Rows;
        this.Columns = Columns;
        board = new Board();
        board.generator(Rows, Columns, Trees);
        CellsTable = new JButton[Rows][Columns];
        setLayout(new GridLayout(Rows, Columns));
        for (int row = 0; row<Rows; row++){
            for(int column = 0; column<Columns; column++){
                cell = new JButton();
                cell.setOpaque(true);
                cell.setEnabled(false);
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
    }

    public void NextState2(float ProL, float ProT) throws InterruptedException {
        while (true){
            board.Update(ProL, ProT);
            refresh();
            TimeUnit.SECONDS.sleep(2);
        }
    }

    public void refresh(){
        for(int x = 0; x<Rows; x++){
            for(int y = 0; y<Columns; y++){
                String ActualValue = board.Board[x][y].getState();
                if(ActualValue == "Tree"){
                    CellsTable[x][y].setBackground(Color.green);
                }
                else if(ActualValue == "Burning"){
                    CellsTable[x][y].setBackground(Color.red);
                }
                else{
                    CellsTable[x][y].setBackground(Color.DARK_GRAY);
                }
            }
        }
    }
}
