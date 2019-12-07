package com.company.tictactoe;

import com.company.tictactoe.player.Player;

import java.util.ArrayList;

public class TicTacToeEngine {
    ArrayList<Player> players = new ArrayList<>();
    Board board;

    public TicTacToeEngine(Player player1, Player player2) {
        players.add(player1);
        players.add(player2);
    }

    public void start() {
        board = new Board(3, 3);
        int moveCounter = 0;

        while (true) {
            Player currentPlayer = players.get(moveCounter % 2);
            board.put(currentPlayer.makeMove(), currentPlayer.getPiece());
            System.out.println(board);

            moveCounter++;
        }
    }
}
