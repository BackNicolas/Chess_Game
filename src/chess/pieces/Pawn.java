
package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {

            // Above one move
            p.setValues(position.getRow() - 1, position.getColumn());

            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // Above two moves
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());

            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // Left Diagonal
            p.setValues(position.getRow() - 1, position.getColumn() - 1);

            if (getBoard().positionExists(p) && isThereAnyOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // Right Diagonal
            p.setValues(position.getRow() - 1, position.getColumn() + 1);

            if (getBoard().positionExists(p) && isThereAnyOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {

            // Above one move
            p.setValues(position.getRow() + 1, position.getColumn());

            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // Above two moves
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());

            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // Left Diagonal
            p.setValues(position.getRow() + 1, position.getColumn() - 1);

            if (getBoard().positionExists(p) && isThereAnyOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // Right Diagonal
            p.setValues(position.getRow() + 1, position.getColumn() + 1);

            if (getBoard().positionExists(p) && isThereAnyOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        return mat;
    }
    
    @Override
    public String toString() {
    	return "P";
    }
}

