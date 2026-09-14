package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testNewBoard() {
        assertNull(board.getWinner());
        assertEquals(Player.X, board.getCurrentTurn());
        assertTrue(board.isInProgressMode());
    }

    @Test
    void testMarkInvalidPosition() {
        Board b = board;
        board.mark(-1, -1);
        assertEquals(b, board);
    }

    @Test
    void testMarkFinishingMove() {
        board.mark(0, 0);
        board.mark(1, 0);
        board.mark(1, 1);
        board.mark(0, 1);
        board.mark(2, 2);
        assertTrue(board.isInFinishedMode());
        assertEquals(Player.X, board.getWinner());
    }

    @Test
    void testMarkNonFinishingMove() {
        board.mark(0, 0);
        assertTrue(board.isInProgressMode());
        assertNull(board.getWinner());
        assertEquals(Player.O, board.getCurrentTurn());
    }

    @Test
    void testPlayingInFinishedGame() {
        board.mark(0, 0);
        board.mark(1, 0);
        board.mark(1, 1);
        board.mark(0, 1);
        board.mark(2, 2);
        assertEquals(Player.X, board.getCurrentTurn());
        board.mark(0, 2);
        assertEquals(Player.X, board.getCurrentTurn());
    }

    @Test
    void testRowOutOfBounds() {
        board.mark(-1, 0);
        assertEquals(Player.X, board.getCurrentTurn());
        board.mark(3, 0);
        assertEquals(Player.X, board.getCurrentTurn());
    }

    @Test
    void testColumnOutOfBounds() {
        board.mark(0, -1);
        assertEquals(Player.X, board.getCurrentTurn());
        board.mark(0, 3);
        assertEquals(Player.X, board.getCurrentTurn());
    }

    @Test
    void testPlayingInNonEmptyCell() {
        board.mark(0, 0);
        assertEquals(Player.O, board.getCurrentTurn());
        board.mark(0, 0);
        assertEquals(Player.O, board.getCurrentTurn());
    }

    @Test
    void testPlayingValidPosition() {
        assertEquals(Player.X, board.getCurrentTurn());
        board.mark(0, 1);
        assertEquals(Player.O, board.getCurrentTurn());
    }

    @Test
    void testPlayWinsHorizontally() {
        board.mark(0, 0);
        board.mark(1, 0);
        board.mark(0, 1);
        board.mark(1, 1);
        board.mark(0, 2);

        assertTrue(board.isInFinishedMode());
        assertEquals(Player.X, board.getWinner());
    }

    @Test
    void testPlayerWinsVertically() {
        board.mark(0, 0);
        board.mark(0, 1);
        board.mark(1, 0);
        board.mark(1, 1);
        board.mark(2, 0);

        assertTrue(board.isInFinishedMode());
        assertEquals(Player.X, board.getWinner());
    }

    @Test
    void testPlayerWinsDiagonallyA() {
        board.mark(0, 0);
        board.mark(0, 1);
        board.mark(1, 1);
        board.mark(0, 2);
        board.mark(2, 2);

        assertTrue(board.isInFinishedMode());
        assertEquals(Player.X, board.getWinner());
    }

    @Test
    void testXWinsDiagonallyB() {
        board.mark(2, 0);
        board.mark(0, 0);
        board.mark(1, 1);
        board.mark(1, 0);
        board.mark(0, 2);

        assertTrue(board.isInFinishedMode());
        assertEquals(Player.X, board.getWinner());
    }

    /**
     * /**
     * CE14
     * Result =
     * | O | X | X |
     * | X | O | O |
     * | X | O | X |
     *
    @Test
    void testNullGame() {
        board.mark(0, 0);
        board.mark(0, 1);
        board.mark(0, 2);
        board.mark(1, 1);
        board.mark(1, 0);
        board.mark(1, 2);
        board.mark(2, 1);
        board.mark(2, 0);
        board.mark(2, 2);
      
        assertTrue(board.isInFinishedMode());
        assertNull(board.getWinner());
    }*/

}
