package com.company.tictactoe.player;

import com.company.tictactoe.piece.Piece;

import java.util.Random;

public class AIPlayer extends Player {
    Random random = new Random();

    public AIPlayer(Piece piece) {
        super(piece);
    }

    @Override
    public int makeMove() {
        return random.nextInt(9);
    }
}
