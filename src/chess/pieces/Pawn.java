
package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	
	private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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
            
            // en Passan White
            
            if(position.getRow() == 3) {
            	Position left = new Position(position.getRow(), position.getColumn() - 1);
            	if(getBoard().positionExists(left) && isThereAnyOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassanValible()) {
            		mat[left.getRow() - 1][left.getColumn()] = true;
            	}
            	Position rigth = new Position(position.getRow(), position.getColumn() + 1);
            	if(getBoard().positionExists(rigth) && isThereAnyOpponentPiece(rigth) && getBoard().piece(rigth) == chessMatch.getEnPassanValible()) {
            		mat[rigth.getRow() - 1][rigth.getColumn()] = true;
            	}
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
            
            // en Passan Black
            
            if(position.getRow() == 4) {
            	Position left = new Position(position.getRow(), position.getColumn() - 1);
            	if(getBoard().positionExists(left) && isThereAnyOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassanValible()) {
            		mat[left.getRow() + 1][left.getColumn()] = true;
            	}
            	Position rigth = new Position(position.getRow(), position.getColumn() + 1);
            	if(getBoard().positionExists(rigth) && isThereAnyOpponentPiece(rigth) && getBoard().piece(rigth) == chessMatch.getEnPassanValible()) {
            		mat[rigth.getRow() + 1][rigth.getColumn()] = true;
            	}
            }
        }
        return mat;
    }
    
    @Override
    public String toString() {
    	return "P";
    }
}

