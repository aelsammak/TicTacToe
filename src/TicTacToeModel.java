import java.util.*;

public class TicTacToeModel {

    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED}

    private final char[][] grid;
    private boolean turn;
    private Status status;

    private final List<TicTacToeView> TicTacToeViews;


    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;
        TicTacToeViews = new ArrayList<>();
    }

    public void addTicTacToeView(TicTacToeView tttv) {
        TicTacToeViews.add(tttv);
    }

    public void removeTicTacToeView(TicTacToeView tttv) {
        TicTacToeViews.remove(tttv);
    }

    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() { return status; }

    private Status updateStatus() {

        // Checking for row win
        for(int i = 0; i < SIZE; i++) {
            if((grid[i][0] == grid[i][1]) && (grid[i][1] == grid[i][2]) && (grid[i][0] != ' ')) {
                if(grid[i][0] == 'X') {
                    return Status.X_WON;
                } else {
                    return Status.O_WON;
                }
            }
        }

        // Checking for column win
        for(int j = 0; j < SIZE; j++) {
            if((grid[0][j] == grid[1][j]) && (grid[1][j] == grid[2][j]) && (grid[0][j] != ' ')) {
                if(grid[0][j] == 'X') {
                    return Status.X_WON;
                } else {
                    return Status.O_WON;
                }
            }
        }

        // Diagonal Win #1
        if((grid[0][0] != ' ') && (grid[0][0] == grid[1][1]) && (grid[1][1] == grid[2][2])) {
            if(grid[0][0] == 'X'){
                return Status.X_WON;
            }
            return Status.O_WON;
        }

        // Diagonal Win #2
        if((grid[0][2] != ' ') && (grid[0][2] == grid[1][1]) && (grid[1][1] == grid[2][0])) {
            if(grid[0][2] == 'X'){
                return Status.X_WON;
            }
            return Status.O_WON;
        }

        // If the game is still ongoing
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == ' ') {
                    return Status.UNDECIDED;
                }
            }
        }

        // return a TIE
        return Status.TIE;
    }

    public boolean getTurn() {return turn;}

    public void play(int x, int y) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn? 'X' : 'O';
        status = updateStatus();
        for(TicTacToeView tttv : TicTacToeViews) tttv.handleTicTacToeUpdate(new TicTacToeEvent(this, status, x, y));
        changeTurn();
    }
}
