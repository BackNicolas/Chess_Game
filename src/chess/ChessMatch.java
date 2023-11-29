package chess;

import boardGame.Board;

public class ChessMatch {
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumms()];
		for(int i=0;i<0;i++) {
			for(int j=0;j<0;j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
}
