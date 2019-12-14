package com.company.tictactoe;

import com.company.tictactoe.board.piece.OPiece;
import com.company.tictactoe.board.piece.XPiece;
import com.company.tictactoe.player.StrongAIPlayer;
import com.company.tictactoe.player.HumanPlayer;
import com.company.tictactoe.player.Player;

public class Main {
    final static String NEW_AI_GAME = "Nowa gra z komputerem";
    final static String NEW_HUMAN_GAME = "Nowa gra human vs human";
    final static String NEW_AI_AI_GAME = "Nowa gra AI vs AI";
    final static String EXIT = "Zakończ program";
    public static void main(String[] args) {
        Player player1 = new StrongAIPlayer(new XPiece());
        Player player2 = new StrongAIPlayer(new OPiece());

        Menu menu = new Menu();
        menu.add(NEW_AI_GAME);
        menu.add(NEW_HUMAN_GAME);
        menu.add(NEW_AI_AI_GAME);
        menu.add(EXIT);
        menu.print();

        switch (menu.chosenOptions()) {
            case NEW_AI_GAME:
                player1 = new HumanPlayer(new XPiece());
                break;

            case NEW_HUMAN_GAME:
                player1 = new HumanPlayer(new XPiece());
                player2 = new HumanPlayer(new OPiece());
                break;

            case NEW_AI_AI_GAME:
                player1 = new StrongAIPlayer(new OPiece());
                player2 = new StrongAIPlayer(new XPiece());
                break;

            default:
                System.exit(1);
        }

        TicTacToeEngine engine = new TicTacToeEngine(player1, player2);
        engine.start();
    }
}
