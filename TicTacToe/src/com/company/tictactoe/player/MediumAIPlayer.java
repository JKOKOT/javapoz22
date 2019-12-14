package com.company.tictactoe.player;

import com.company.tictactoe.Judge;
import com.company.tictactoe.board.Board;
import com.company.tictactoe.board.InvalidFieldIndex;
import com.company.tictactoe.board.piece.Piece;

import java.util.*;

public class MediumAIPlayer extends Player {
    Random random = new Random();

    public MediumAIPlayer(Piece piece) {
        super(piece);
    }

    @Override
    public int makeMove(Board board) {
        //sprawdza szansę na wygraną
        try {
            // dzięki temu, że `piece` w klasie Player jest protected mamy do niego dostęp
            return winningMove(board, piece);
        } catch (MoveNotFound e) {}

        try {
            // dzięki temu, że `opponentPiece` w klasie Player jest protected mamy do niego dostęp
            return winningMove(board, opponentPiece);
        } catch (MoveNotFound e) {
            return random.nextInt(9) + 1;
        }
    }

    private int winningMove(Board board, Piece piece) throws MoveNotFound {
        Judge coach = new Judge(board);
        int i = 1;
        while (true) {
            try {
                if (board.getField(i).isEmpty()) {
                    board.put(i, piece);
                    if (coach.isWin()) {
                        return i;
                    }
                    board.remove(i);
                }
                i++;
            } catch (InvalidFieldIndex e) {
                break;
            }
        }

        throw new MoveNotFound();
    }
}
