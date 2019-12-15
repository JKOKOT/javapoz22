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
        HashMap<Integer, Integer> movesMap = new HashMap<>();
        for (int i = 1; true; i++) {
            try {
                if (board.getField(i).isEmpty()) {
                    Board copyBoard = new Board(board);
                    copyBoard.put(i, piece);

                    int score = scoreBoard(copyBoard, whosMove(copyBoard));
                    movesMap.put(i, score);
                }
            } catch (InvalidFieldIndex e) {
                break;
            }
        }
        System.out.println(movesMap);

        List<Integer> moves = new ArrayList(movesMap.keySet());
        Collections.shuffle(moves);
        int bestValue = Collections.max(movesMap.values());
        for (Integer move : moves) {
            if (movesMap.get(move) == bestValue) {
                return move;
            }
        }

        return moves.get(0); // tu i tak nigdy nie dojdzie
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
