package com.company.tictactoe.player;

import com.company.tictactoe.board.piece.Piece;

public abstract class Player {
    private Piece piece;
    public abstract int makeMove();

    public Player(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
