package com.company.tictactoe;

import com.company.tictactoe.board.Board;
import com.company.tictactoe.board.InvalidFieldIndex;

public class JudgeStatic {
    public static boolean checkMove(Board board, int fieldIndex) {
        try {
            return board.getField(fieldIndex).isEmpty();
        } catch (InvalidFieldIndex e) {
            return false;
        }
    }

    public static boolean isGameOver(Board board) {
        return board.isFull();
    }
}
