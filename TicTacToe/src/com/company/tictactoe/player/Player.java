package com.company.tictactoe.player;

import com.company.tictactoe.board.Board;
import com.company.tictactoe.board.piece.Piece;

public abstract class Player {
    private Piece piece;
    public abstract int makeMove(Board board);

    public Player(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
