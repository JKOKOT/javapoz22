package com.company.tictactoe.player;

import com.company.tictactoe.Judge;
import com.company.tictactoe.board.Board;
import com.company.tictactoe.board.InvalidFieldIndex;
import com.company.tictactoe.board.piece.OPiece;
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

        //sprawdza szansę na wygraną
        int bestMove = findBestMove(board, new OPiece());
        if (bestMove != -1) {
            return bestMove;
        }

        bestMove = findBestMove(board, new XPiece());
        if (bestMove != -1) {
            return bestMove;
        }

        return random.nextInt(9);
    }

    //zwraca -1 jeżeli nie ma szans
    private int findBestMove(Board board, Piece piece) {
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

        return -1;
    }
}
