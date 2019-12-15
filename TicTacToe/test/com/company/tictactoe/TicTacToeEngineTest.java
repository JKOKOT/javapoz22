package com.company.tictactoe;

import com.company.tictactoe.board.Board;
import com.company.tictactoe.board.piece.OPiece;
import com.company.tictactoe.board.piece.XPiece;
import com.company.tictactoe.player.MediumAIPlayer;
import com.company.tictactoe.player.Player;
import com.company.tictactoe.player.StrongAIPlayer;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeEngineTest {

    @Test
    void runAIvsAIAndAssertDraw() {
        TicTacToeEngine engine = new TicTacToeEngine(
                new StrongAIPlayer(new XPiece()),
                new StrongAIPlayer(new OPiece())
        );

        assertEquals(GameResult.DRAW, engine.start());
    }

    @Test
    void playerOneWins() {
        Player player = mock(Player.class);

        when(player.makeMove(any()))
            .thenReturn(2)
            .thenReturn(6)
            .thenReturn(8)
            .thenReturn(4)
            .thenReturn(9)
            .thenReturn(7)
            .thenReturn(1)
            .thenReturn(3);

        when(player.getPiece()).thenReturn(new OPiece());

        TicTacToeEngine engine = new TicTacToeEngine(
                player,
                new StrongAIPlayer(new XPiece())
        );
        assertEquals(GameResult.PLAYER_TWO_WON, engine.start());
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}