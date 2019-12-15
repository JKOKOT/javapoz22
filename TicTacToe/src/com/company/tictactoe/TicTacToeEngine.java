package com.company.tictactoe;

import com.company.tictactoe.board.Board;
import com.company.tictactoe.player.Player;

import java.util.ArrayList;

public class TicTacToeEngine {
    private ArrayList<Player> players = new ArrayList<>();
    private Judge judge;
    private Board board;
    private int moveCounter = 0;

    public TicTacToeEngine(Player playerOne, Player playerTwo) {
        players.add(playerOne);
        players.add(playerTwo);
    }

    public GameResult start() {
        board = new Board(3, 3);
        judge = new Judge(board);

        while (!judge.isGameOver()) {
            Player currentPlayer = players.get(moveCounter % 2);

            // Tworząc kopię Board zabezpieczamy się przed
            // "hackowaniem" przez graczy, bo nie mogą wprowadzić nieuczciwie znaku:
            Board copyBoard = new Board(board);

            System.out.println(board);
            int currentMove = currentPlayer.makeMove(copyBoard);


            if (judge.checkMove(currentMove)) {
                board.put(currentMove, currentPlayer.getPiece());
            } else {
                System.out.println("Niepoprawny ruch");
                continue;
            }

            System.out.println(board);

            moveCounter++;
        }

        if (!judge.isWin()) {
            return GameResult.DRAW;
        }

        if(judge.isWin(players.get(0).getPiece())) {
            return GameResult.PLAYER_ONE_WON;
        } else {
            return GameResult.PLAYER_TWO_WON;
        }
    }
}
