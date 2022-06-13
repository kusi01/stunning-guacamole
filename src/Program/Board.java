package Program;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    public int Columns;
    public int Rows;
    public float ProbabilityLightning;
    public float ProbabilityTree;
    public int NumberOfTrees;
    public Cell[][] Board;


    public void generator(int Rows, int Columns, int Trees){
        this.Columns = Columns;
        this.Rows = Rows;
        this.NumberOfTrees = Trees;
        ArrayList<Cell> CellList = new ArrayList<Cell>();
        Random random = new Random();
        Board = new Cell[Rows][Columns];
        for (int x = 0; x<Rows; x++){
            for(int y = 0; y<Columns; y++){
                Board[x][y] = new Cell(x,y,"Empty");
                CellList.add(Board[x][y]);
            }
        }
        for (int Tree = 0; Tree<Trees; Tree++){
            int a = random.nextInt(CellList.size());
            CellList.get(a).SetState("Tree");
            CellList.remove(a);
        }
    }

    public void Update(float ProL, float ProT){
        Cell[][] Board2 = new Cell[Rows][Columns];
        ProbabilityTree = ProT;
        ProbabilityLightning = ProL;
        Random random = new Random();
        for(int x = 0; x<Rows; x++) {
            for (int y = 0; y < Columns; y++) {
                String ActualState = Board[x][y].getState();
                Board2[x][y] = new Cell(x, y, ActualState);
                if (ActualState == "Empty") {
                    float z = random.nextInt(1, 101);
                    if (z <= ProbabilityTree) {
                        Board2[x][y].SetState("Tree");
                    }
                } else if (ActualState == "Tree") {
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (x + i >= 0 && y + j >= 0 && x + i < Rows && y + j < Columns) {
                                if (Board[x + i][y + j].getState() == "Burning") {
                                    Board2[x][y].SetState("Burning");
                                }
                            }
                            }} if(Board[x][y].getState() == "Tree") {
                                float p = random.nextInt(1, 101);
                                if (p <= ProbabilityLightning) {
                                    Board2[x][y].SetState("Burning");
                                }
                            }
                }
                    else if (ActualState == "Burning") {
                Board2[x][y].SetState("Empty");
            }
        }
                }
        Board = Board2;
            }
        }
