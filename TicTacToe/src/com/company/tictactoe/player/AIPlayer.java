package com.company.tictactoe.player;

import com.company.tictactoe.Judge;
import com.company.tictactoe.board.Board;
import com.company.tictactoe.board.InvalidFieldIndex;
import com.company.tictactoe.board.piece.XPiece;
import com.company.tictactoe.board.piece.Piece;

import java.util.Random;

public class AIPlayer extends Player {
    Random random = new Random();

    public AIPlayer(Piece piece) {
        super(piece);
    }

    @Override
    public int makeMove(Board board) {
        Judge coach = new Judge(board);
        int i = 1;

        while (true) {
            try {
                if (board.getField(i).isEmpty()) {
                    board.put(i, new XPiece());
                    if(coach.isWin()) {
                        return i;
                    }
                    board.remove(i);
                }
            } catch (InvalidFieldIndex e) {
                break;
            }
            i++;
        }

        return random.nextInt(9);
    }
}
