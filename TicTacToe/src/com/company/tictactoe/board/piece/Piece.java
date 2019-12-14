package com.company.tictactoe.board.piece;

public abstract class Piece {
    // klasy XPiece i OPiece dziedziczą po Piece, obie powinny mieć swój znak,
    // dlatego deklarujemy go tutaj
    protected char sign;

    public char getSign() {
        return sign;
    }

    // Nadpisujemy, bo domyślnie equals porównuje referencje
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Piece otherPiece = (Piece)obj;
        return otherPiece.getSign() == this.getSign();
    }

    @Override
    public String toString() {
        return String.valueOf(getSign());
    }
}
