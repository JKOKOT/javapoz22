package com.company.tictactoe;

import com.company.tictactoe.player.Player;

import java.util.ArrayList;

public class TicTacToeEngine {
    ArrayList<Player> players = new ArrayList<>();

    public TicTacToeEngine(Player player1, Player player2) {
        players.add(player1);
        players.add(player2);
    }

    public void start() {
        int moveCounter = 0;

        while (true) {
            Player currentPlayer = players.get(moveCounter % 2);
            System.out.println("Gracz " + currentPlayer.getSign() + " wykonał ruch:");
            System.out.println(currentPlayer.makeMove());

            moveCounter++;
        }
    }
}
