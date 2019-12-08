package com.company.tictactoe.board;

import com.company.tictactoe.board.piece.Piece;

public class Field {
    private Piece piece;

    public boolean isEmpty() {
        return piece == null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
