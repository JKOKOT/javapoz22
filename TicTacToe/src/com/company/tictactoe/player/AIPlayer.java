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
        for (int i = 1; true; i++) {
            try {
                if (board.getField(i).isEmpty()) {
                    board.put(i, piece);


                    if (scoreBoard(board, true) == 1) {
                        return i;
                    }

                    board.remove(i);
                }
            } catch (InvalidFieldIndex e) {
            }
        }

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
//            System.out.println(board);
//            System.out.println("isMaximizing:" + isMaximizing);
//            System.out.println("score:" + 0);
            return 0;
        }

        if ((coach.isWin(piece) && isMaximizing) || (coach.isWin(opponentPiece) && !isMaximizing)) {
//            System.out.println(board);
//            System.out.println("isMaximizing:" + isMaximizing);
//            System.out.println("score:" + 1);
            return 1;
        }
        if ((coach.isWin(opponentPiece) && isMaximizing) || (coach.isWin(piece) && !isMaximizing)) {
//            System.out.println(board);
//            System.out.println("isMaximizing:" + isMaximizing);
//            System.out.println("score:" + -1);
            return -1;
        }

        for (int i = 1; true; i++) {
            try {
                if (boardCopy.getField(i).isEmpty()) {
                    boardCopy.put(i, isMaximizing ? piece : opponentPiece);
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
