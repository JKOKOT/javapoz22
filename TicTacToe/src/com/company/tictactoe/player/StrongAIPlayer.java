package com.company.tictactoe.player;

import com.company.tictactoe.Judge;
import com.company.tictactoe.board.Board;
import com.company.tictactoe.board.InvalidFieldIndex;
import com.company.tictactoe.board.piece.Piece;

import java.util.*;

public class StrongAIPlayer extends Player {

    public StrongAIPlayer(Piece piece) {
        super(piece);
    }

    @Override
    public int makeMove(Board board) {
        HashMap<Integer, Integer> moves = new HashMap<>();
        for (int i = 1; true; i++) {
            try {
                if (board.getField(i).isEmpty()) {
                    board.put(i, piece);

                    int score = scoreBoard(board, true);
                    moves.put(i, score);


                    board.remove(i);
                }
            } catch (InvalidFieldIndex e) {
                break;
            }
        }

        System.out.println(moves);
        int bestMove = 1;
        int bestValue = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : moves.entrySet()) {
            int move = entry.getKey();
            int value = entry.getValue();

            if (value > bestValue) {
                bestMove = move;
                bestValue = value;
            }

            // do what you have to do here
            // In your case, another loop.
        }
        return bestMove;
    }

    private int scoreBoard(Board board, boolean isMaximizing) {
        Board boardCopy = new Board(board);

        int score = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        Judge coach = new Judge(boardCopy);

        if (coach.isWin(piece)) {
            return 10;
        }

        if (coach.isWin(opponentPiece)) {
            return -10;
        }

        if(coach.isGameOver()) {
            return 0;
        }

        for (int i = 1; true; i++) {
            try {
                if (boardCopy.getField(i).isEmpty()) {
                    boardCopy.put(i, whosMove());
                    if (isMaximizing) {
                        score = Math.max(scoreBoard(boardCopy, true), score);
                    } else {
                        score = Math.min(scoreBoard(boardCopy, false), score);
                    }
                    boardCopy.remove(i);
                }
            } catch (InvalidFieldIndex e) {
                break;
            }
        }

        return score;
    }

    private Piece whosMove() {

    }
}
