/**
 * Created by Birthright on 29.11.2015.
 */
public class Stone {

    private Chain chain;
    private StoneColor state;
    private int liberties;
    private int row;
    private int col;

    public Chain getChain() {
        return chain;
    }

    public void setChain(Chain chain) {
        this.chain = chain;
    }

    public StoneColor getState() {
        return state;
    }

    public void setState(StoneColor state) {
        this.state = state;
    }

    public int getLiberties() {
        return liberties;
    }

    public void setLiberties(int liberties) {
        this.liberties = liberties;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Stone(int row, int col, StoneColor state) {
        chain = null;
        this.state = state;
        if ((row == 0 && (col == 0 || col == GameBoard.SIZE - 1)) || (row == GameBoard.SIZE - 1 && (col == 0 || col == GameBoard.SIZE - 1))) {
            liberties = 2;
        } else {
            if ((row == 0 && (col > 0 && col < GameBoard.SIZE - 1)) || (row == GameBoard.SIZE - 1 && (col > 0 && col < GameBoard.SIZE))
                    || (col == 0 && (row > 0 && row < GameBoard.SIZE - 1)) || (col == GameBoard.SIZE - 1 && (row > 0 && row < GameBoard.SIZE - 1))) {
                liberties = 3;
            } else {
                liberties = 4;
            }
            this.row = row;
            this.col = col;
        }
    }
}
