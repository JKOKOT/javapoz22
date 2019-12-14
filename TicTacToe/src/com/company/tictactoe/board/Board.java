package com.company.tictactoe.board;

import com.company.tictactoe.board.piece.Piece;
import com.company.tictactoe.board.piece.XPiece;

public class Board {
    private int xSize;
    private int ySize;
    private Field[][] board;

    public Board(Board board) {
        this(board.getxSize(), board.getySize());

        int i = 1;
        while (true) {
            try {
                if (!board.getField(i).isEmpty()) {
                    this.put(i, board.getField(i).getPiece());
                }
            } catch (InvalidFieldIndex e) {
//                System.out.println("index " + i + " spowodował bład");
                break;
            }
            i++;
        }
    }

    public Board(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        board = new Field[xSize][ySize];

        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                board[x][y] = new Field();
            }
        }
    }

    public Field getField(int fieldIndex) throws InvalidFieldIndex {
        int index = 1;
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                if (index == fieldIndex) {
                    return board[x][y];
                }
                index++;
            }
        }

        throw new InvalidFieldIndex();
    }

    public void put(int fieldIndex, Piece piece) {
        int index = 1;
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                if (index == fieldIndex) {
                    board[x][y].setPiece(piece);
                }
                index++;
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        int index = 1;
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                if(!board[x][y].isEmpty()) {
                    result += "[" + board[x][y].getPiece().getSign() + "]";
                } else {
                    result += "[" + index + "]";
                }
                index++;
            }
            result += "\n";
        }

        return result;
    }

    public boolean isFull() {
        int size = xSize * ySize;
        for(int i = 1; i <= size; i++) {
            try {
                if(getField(i).isEmpty()) {
                    return false;
                }
            } catch (InvalidFieldIndex e) {
                return true;
            }
        }

        return true;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public void remove(int i) {
        put(i, null); // brak pionka to null
    }
}
