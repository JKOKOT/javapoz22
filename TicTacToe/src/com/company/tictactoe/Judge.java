package com.company.tictactoe;

import com.company.tictactoe.board.Board;
import com.company.tictactoe.board.Field;
import com.company.tictactoe.board.InvalidFieldIndex;
import com.company.tictactoe.board.piece.Piece;

public class Judge {
    private Board board;
    private final static int[][] WINNING_COMBINATIONS = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9},
            {1, 5, 9},
            {3, 5, 7}
        };

    public Judge(Board board) {
        this.board = board;
    }

    public boolean checkMove(int fieldIndex) {
        try {
            return board.getField(fieldIndex).isEmpty();
        } catch (InvalidFieldIndex e) {
            return false;
        }
    }

    public boolean isGameOver() {
        return isWin() || board.isFull();
    }

    public boolean isWin() {
        for (int[] winningCombination: WINNING_COMBINATIONS) {
            if (isWinningCombination(winningCombination)) {
                return true;
            }
        }

        return false;
    }

    public boolean isWin(Piece piece) {
        for (int[] winningCombination: WINNING_COMBINATIONS) {
            if (isWinningCombination(winningCombination)) {
                try {
                    return board.getField(winningCombination[0]).getPiece().equals(piece);
                }catch (InvalidFieldIndex e) {}
            }
        }

        return false;
    }

    private boolean isWinningCombination(int[] winningCombination) {
        Field firstPiece;
        Field secondPiece;
        Field thirdPiece;

        try {
            firstPiece = board.getField(winningCombination[0]);
            secondPiece = board.getField(winningCombination[1]);
            thirdPiece = board.getField(winningCombination[2]);
        } catch (InvalidFieldIndex e) {
            return false;
        }

        if (firstPiece.isEmpty()) {
            return false;
        }

        // koniecznie używamy .equals(),
        // bo nie chcemy porównywać referencji, a wartości znaków getSign()
        if(
            firstPiece.getPiece().equals(secondPiece.getPiece())
            && secondPiece.getPiece().equals(thirdPiece.getPiece())
        ) {
            return true;
        }

        return false;
    }
}









