package Program;

public class Cell {
    public int Row;
    public int Column;
    public String State;

    public Cell(int Row, int Column, String State){
        this.Row = Row;
        this.Column = Column;
        this.State = State;
    }

    public void SetState(String State){
        this.State = State;
    }

    public String getState() {
        return State;
    }
}
