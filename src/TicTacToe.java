import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    JFrame frame;
    JButton[] buttons;
    boolean player1Turn = true;

    public TicTacToe() {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(420, 50,600,600);
        frame.setLayout(new GridLayout(3, 3));

        buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        if (player1Turn) {
            buttonClicked.setText("X");
        } else {
            buttonClicked.setText("O");
        }
        buttonClicked.setEnabled(false);
        player1Turn = !player1Turn;
        checkForWin();
    }

    public void checkForWin() {
        String[] board = new String[9];
        for (int i = 0; i < 9; i++) {
            board[i] = buttons[i].getText();
        }
        if (board[0].equals(board[1]) && board[1].equals(board[2]) && !board[0].equals("")) {
            showWinningMessage(board[0]);
        }
        if (board[3].equals(board[4]) && board[4].equals(board[5]) && !board[3].equals("")) {
            showWinningMessage(board[3]);
        }
        if (board[6].equals(board[7]) && board[7].equals(board[8]) && !board[6].equals("")) {
            showWinningMessage(board[6]);
        }
        if (board[0].equals(board[3]) && board[3].equals(board[6]) && !board[0].equals("")) {
            showWinningMessage(board[0]);
        }
        if (board[1].equals(board[4]) && board[4].equals(board[7]) && !board[1].equals("")) {
            showWinningMessage(board[1]);
        }
        if (board[2].equals(board[5]) && board[5].equals(board[8]) && !board[2].equals("")) {
            showWinningMessage(board[2]);
        }
        if (board[0].equals(board[4]) && board[4].equals(board[8]) && !board[0].equals("")) {
            showWinningMessage(board[0]);
        }
        if (board[2].equals(board[4]) && board[4].equals(board[6]) && !board[2].equals("")) {
            showWinningMessage(board[2]);
        }
    }

    public void showWinningMessage(String winner) {
        JOptionPane.showMessageDialog(frame, "Game Over! " + winner + " wins!");
        System.exit(0);
    }

    public static void main(String[] args) {
        new TicTacToe();
 }
}