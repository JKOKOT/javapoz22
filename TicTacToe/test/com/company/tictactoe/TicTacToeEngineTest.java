package com.company.tictactoe;

import com.company.tictactoe.board.piece.OPiece;
import com.company.tictactoe.board.piece.XPiece;
import com.company.tictactoe.player.Player;
import com.company.tictactoe.player.StrongAIPlayer;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeEngineTest {
    Player dummyPlayer;

    @BeforeEach
    void setUp() {
        dummyPlayer = mock(Player.class);

        when(dummyPlayer.makeMove(any()))
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(4)
                .thenReturn(8)
                .thenReturn(9)
                .thenReturn(6)
                .thenReturn(1)
                .thenReturn(3);

        when(dummyPlayer.getPiece()).thenReturn(new OPiece());
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void runAIvsAIAndAssertDraw() {
        TicTacToeEngine engine = new TicTacToeEngine(
                new StrongAIPlayer(new XPiece()),
                new StrongAIPlayer(new OPiece())
        );

        assertEquals(GameResult.DRAW, engine.start());
    }

    @Test
    void playerTwoWins() {
        TicTacToeEngine engine = new TicTacToeEngine(
                dummyPlayer,
                new StrongAIPlayer(new XPiece())
        );
        assertEquals(GameResult.PLAYER_TWO_WON, engine.start());
    }

    @Test
    void playerOneWins() {
         TicTacToeEngine engine = new TicTacToeEngine(
                new StrongAIPlayer(new XPiece()),
                 dummyPlayer
        );
        assertEquals(GameResult.PLAYER_ONE_WON, engine.start());
    }

}