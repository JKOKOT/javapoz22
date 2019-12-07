package com.company.tictactoe;

import com.company.tictactoe.piece.OPiece;
import com.company.tictactoe.piece.XPiece;
import com.company.tictactoe.player.AIPlayer;
import com.company.tictactoe.player.HumanPlayer;
import com.company.tictactoe.player.Player;

public class Main {
    public static void main(String[] args) {
        Player human = new HumanPlayer(new XPiece());
        Player computer = new AIPlayer(new OPiece());

        TicTacToeEngine engine = new TicTacToeEngine(human, computer);
        engine.start();
    }
}
