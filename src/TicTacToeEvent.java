import java.util.EventObject;

public class TicTacToeEvent extends EventObject {

    private final TicTacToeModel.Status status;
    private final int x;
    private final int y;

    public TicTacToeEvent(TicTacToeModel ticTacToeModel, TicTacToeModel.Status status, int x, int y) {
        super(ticTacToeModel);
        this.status = status;
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public TicTacToeModel.Status getStatus() { return status; }

}
