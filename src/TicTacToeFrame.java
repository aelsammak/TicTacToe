import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame implements TicTacToeView {

    private final JButton[][] buttons;

    public TicTacToeFrame() {
        super("Tic Tac Toe!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(TicTacToeModel.SIZE, TicTacToeModel.SIZE));
        TicTacToeModel tttm = new TicTacToeModel();
        tttm.addTicTacToeView(this);
        TicTacToeController tttc = new TicTacToeController(tttm);
        buttons = new JButton[TicTacToeModel.SIZE][TicTacToeModel.SIZE];
        for (int i = 0; i < TicTacToeModel.SIZE; i++) {
            for (int j = 0; j < TicTacToeModel.SIZE; j++) {
                JButton b = new JButton(" ");
                buttons[i][j] = b;
                b.addActionListener(tttc);
                b.setActionCommand(i + " " + j);
                this.add(b);
            }
        }
        this.setSize(300, 300);
        this.setVisible(true);
    }

    @Override
    public void handleTicTacToeUpdate(TicTacToeEvent e) {
        int x = e.getX();
        int y = e.getY();
        TicTacToeModel tttm = (TicTacToeModel) e.getSource();
        String label = tttm.getTurn()? "X" : "O";
        buttons[x][y].setText(label);
        decideWinner(e.getStatus());
    }

    public void decideWinner(TicTacToeModel.Status e) {
        if(e == TicTacToeModel.Status.TIE) {
            System.out.println("IT WAS A TIE!");
            JOptionPane.showMessageDialog(this, "IT WAS A TIE!");
        } else if(e == TicTacToeModel.Status.X_WON) {
            System.out.println("X WON!");
            JOptionPane.showMessageDialog(this, "X WON!");
        } else if(e == TicTacToeModel.Status.O_WON) {
            System.out.println("O WON!");
            JOptionPane.showMessageDialog(this, "O WON!");
        }
    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
}
