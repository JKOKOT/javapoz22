package com.company.tictactoe.player;

import com.company.tictactoe.board.Board;
import com.company.tictactoe.board.piece.OPiece;
import com.company.tictactoe.board.piece.Piece;
import com.company.tictactoe.board.piece.XPiece;

public abstract class Player {
    protected Piece piece;
    protected Piece opponentPiece;
    public abstract int makeMove(Board board);

    public Player(Piece piece) {
        this.piece = piece;
        if (piece instanceof XPiece) {
            opponentPiece = new OPiece();
        } else  {
            opponentPiece = new XPiece();
        }
    }

    public Piece getPiece() {
        return piece;
    }
}
