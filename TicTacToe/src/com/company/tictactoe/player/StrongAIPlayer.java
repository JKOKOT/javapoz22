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
                    Board copyBoard = new Board(board);
                    copyBoard.put(i, piece);

                    int score = scoreBoard(copyBoard, whosMove(copyBoard));
                    moves.put(i, score);
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

    private int scoreBoard(Board board, Piece whosMove) {
        int score = whosMove.equals(opponentPiece) ? 100 : -100;

        Judge coach = new Judge(board);

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
                if (board.getField(i).isEmpty()) {
                    Board copyBoard = new Board(board);
                    copyBoard.put(i, whosMove);
                    if (whosMove.equals(piece)) {
                        score = Math.max(scoreBoard(copyBoard, whosMove(copyBoard)), score);
                    } else {
                        score = Math.min(scoreBoard(copyBoard, whosMove(copyBoard)), score);
                    }
                }
            } catch (InvalidFieldIndex e) {
                break;
            }
        }

        return score;
    }

    private Piece whosMove(Board board) {
        if (board.getLastPut().equals(piece)) {
            return opponentPiece;
        }

        return piece;
    }
}
