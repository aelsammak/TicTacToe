import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeModelTest {

    TicTacToeModel ticTacToeModel;

    @Before
    public void setUp() {
        ticTacToeModel = new TicTacToeModel();
    }

    @After
    public void tearDown() {
        ticTacToeModel = null;
    }

    @Test
    public void testInitialStatus() {
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }

    @Test
    public void testXRowWin() {
        ticTacToeModel.play(0,0); // X
        ticTacToeModel.play(0, 1); // O
        ticTacToeModel.play(1, 0); // X
        ticTacToeModel.play(0, 2); // O
        ticTacToeModel.play(2, 0); // X
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @Test
    public void testXColWin() {
        ticTacToeModel.play(0,0); // X
        ticTacToeModel.play(1, 1); // O
        ticTacToeModel.play(0, 1); // X
        ticTacToeModel.play(1, 2); // O
        ticTacToeModel.play(0, 2); // X
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @Test
    public void testXDia1Win() {
        ticTacToeModel.play(0,0); // X
        ticTacToeModel.play(1, 0); // O
        ticTacToeModel.play(1, 1); // X
        ticTacToeModel.play(1, 2); // O
        ticTacToeModel.play(2, 2); // X
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @Test
    public void testXDia2Win() {
        ticTacToeModel.play(2,0); // X
        ticTacToeModel.play(1, 0); // O
        ticTacToeModel.play(1, 1); // X
        ticTacToeModel.play(1, 2); // O
        ticTacToeModel.play(0, 2); // X
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @Test
    public void testTie() {
        ticTacToeModel.play(0,0); // X
        ticTacToeModel.play(1, 0); // O
        ticTacToeModel.play(0, 1); // X
        ticTacToeModel.play(0, 2); // O
        ticTacToeModel.play(1, 2); // X
        ticTacToeModel.play(1, 1); // O
        ticTacToeModel.play(2, 0); // X
        ticTacToeModel.play(2, 1); // O
        ticTacToeModel.play(2, 2); // X
        assertEquals(TicTacToeModel.Status.TIE, ticTacToeModel.getStatus());
    }

    @Test
    public void testUndecided() {
        ticTacToeModel.play(0, 0); // X
        ticTacToeModel.play(1, 0); // O
        ticTacToeModel.play(0, 1); // X
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }
}