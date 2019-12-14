package com.company.tictactoe.player;

import com.company.tictactoe.Judge;
import com.company.tictactoe.board.Board;
import com.company.tictactoe.board.InvalidFieldIndex;
import com.company.tictactoe.board.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class AIPlayer extends Player {
    Random random = new Random();
    ArrayList<Integer> gambitList;


    public AIPlayer(Piece piece) {
        super(piece);
        gambitList = new ArrayList<Integer>(
                Arrays.asList(1, 3, 7, 9, 5)
        );
    }

    @Override
    public int makeMove(Board board) {
        Judge coach = new Judge(board);

        //sprawdza szansę na wygraną
        try {
            // dzięki temu, że `piece` w klasie Player jest protected mamy do niego dostęp
            return winningMove(board, piece);
        } catch (MoveNotFound e) {}

        try {
            // dzięki temu, że `opponentPiece` w klasie Player jest protected mamy do niego dostęp
            return winningMove(board, opponentPiece);
        } catch (MoveNotFound e) {
//            return getGambit();
            for (int move: gambitList) {
                board.put(move, piece);
                System.out.println(scoreBoard(board, true));
                board.remove(move);
            }
            return getGambit();
        }
    }

    private int scoreBoard(Board board, boolean isMaximizing) {
        int score = isMaximizing ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        Judge coach = new Judge(board);
        if ((coach.isWin(piece) && isMaximizing) || (coach.isWin(opponentPiece) && !isMaximizing)) {
            return 1;
        }
        if ((coach.isWin(opponentPiece) && isMaximizing) || (coach.isWin(piece) && isMaximizing)) {
            return -1;
        }

        for (int i = 1; true; i++) {
            try {
                if (board.getField(i).isEmpty()) {
                    board.put(i, isMaximizing ? piece : opponentPiece);
                    score = Math.max(scoreBoard(board, !isMaximizing), score);
                    board.remove(i);
                }
            } catch (InvalidFieldIndex e) {
                break;
            }
        }

        return score;
    }

    private int winningMove(Board board, Piece piece) throws MoveNotFound {
        Judge coach = new Judge(board);
        int i = 1;
        while (true) {
            try {
                if (board.getField(i).isEmpty()) {
                    board.put(i, piece);
                    if (coach.isWin()) {
                        return i;
                    }
                    board.remove(i);
                }
                i++;
            } catch (InvalidFieldIndex e) {
                break;
            }
        }

        throw new MoveNotFound();
    }

    private int getGambit() {
        Collections.shuffle(gambitList);
        return gambitList.get(0);
    }
}
