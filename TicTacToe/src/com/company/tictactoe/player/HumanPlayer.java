package com.company.tictactoe.player;

import com.company.tictactoe.board.Board;
import com.company.tictactoe.board.piece.Piece;

import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(Piece piece) {
        super(piece);
    }

    @Override
    public int makeMove(Board board) {
        return scanner.nextInt();
    }
}
