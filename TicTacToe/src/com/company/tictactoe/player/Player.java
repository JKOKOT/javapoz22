package com.company.tictactoe.player;

import com.company.tictactoe.piece.Piece;

public abstract class Player {
    private Piece piece;
    public abstract int makeMove();

    public Player(Piece piece) {
        this.piece = piece;
    }

    public char getSign() {
        return piece.getSign();
    }
}
