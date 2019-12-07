package com.company.tictactoe;

import com.company.tictactoe.board.Board;
import com.company.tictactoe.player.Player;

import java.util.ArrayList;

public class TicTacToeEngine {
    ArrayList<Player> players = new ArrayList<>();
    Judge judge = new Judge();
    Board board;

    public TicTacToeEngine(Player player1, Player player2) {
        players.add(player1);
        players.add(player2);
    }

    public void start() {
        board = new Board(3, 3);
        int moveCounter = 0;

        while (judge.isGameOver()) {
            Player currentPlayer = players.get(moveCounter % 2);
            int currentMove = currentPlayer.makeMove();
            if (judge.checkMove(board, currentMove)) {
                board.put(currentMove, currentPlayer.getPiece());
            } else {
                System.out.println("Niepoprawny ruch");
                continue;
            }

            System.out.println(board);

            moveCounter++;
        }
    }
}
