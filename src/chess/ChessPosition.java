package chess;

import boardGame.Position;

public class ChessPosition {
    private char columm;
    private int row;
    
    public ChessPosition(int row, char columm) {
        if (columm < 'a' || columm > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating chess position. Valid values are from a1 to h8.");
        }
        this.row = row;
        this.columm = columm;
    }

    public int getRow() {
        return row;
    }

    public char getColumm() {
        return columm;
    }
    
    protected Position toPosition() {
        return new Position(8 - row, columm - 'a');
    }
    
    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition(8 - position.getRow(), (char) ('a' + position.getColumm()));
    }
    
    @Override
    public String toString() {
    	return "" + columm + row;
    }
}

