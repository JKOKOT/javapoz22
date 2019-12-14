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
                Arrays.asList(1, 3, 7, 9, 5 ,2,4,6)
        );
    }

    @Override
    public int makeMove(Board board) {
        ArrayList<Integer> moves = new ArrayList<>();
        for (int i = 1; true; i++) {
            try {
                if (board.getField(i).isEmpty()) {
                    board.put(i, piece);

                    System.out.println(board);
                    System.out.println(scoreBoard(board, true));
                    if (scoreBoard(board, true) >= 0) {
                        moves.add(i);
                    }

                    board.remove(i);
                }
            } catch (InvalidFieldIndex e) {
                break;
            }
        }

        return Collections.max(moves);

//        return getGambit();


        //sprawdza szansę na wygraną
/*        try {
            // dzięki temu, że `piece` w klasie Player jest protected mamy do niego dostęp
            return winningMove(board, piece);
        } catch (MoveNotFound e) {}

        try {
            // dzięki temu, że `opponentPiece` w klasie Player jest protected mamy do niego dostęp
            return winningMove(board, opponentPiece);
        } catch (MoveNotFound e) {

        }*/
    }

    private int scoreBoard(Board board, boolean isMaximizing) {
        Board boardCopy = new Board(board);

        int score = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        Judge coach = new Judge(boardCopy);

        if(coach.isGameOver() && !coach.isWin()) {
            return 0;
        }

        if (coach.isWin(piece)) {
            return 10;
        }

        if (coach.isWin(opponentPiece)) {
            return -10;
        }

        for (int i = 1; true; i++) {
            try {
                if (boardCopy.getField(i).isEmpty()) {
                    boardCopy.put(i, isMaximizing ? opponentPiece : piece);
                    if (isMaximizing) {
                        score = Math.max(scoreBoard(boardCopy, !isMaximizing), score);
                    } else {
                        score = Math.min(scoreBoard(boardCopy, !isMaximizing), score);
                    }
                    boardCopy.remove(i);
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
