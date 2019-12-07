package com.company.tictactoe;

import com.company.tictactoe.board.Board;
import com.company.tictactoe.board.InvalidFieldIndex;

public class Judge {
    public boolean checkMove(Board board, int fieldIndex) {
        try {
            return board.getField(fieldIndex).isEmpty();
        } catch (InvalidFieldIndex e) {
            return false;
        }
    }
}
