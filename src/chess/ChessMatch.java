package chess;

import boardgame.Board;
import boardgame.Position;
import chess_pieces.King;
import chess_pieces.Rook;

public class ChessMatch {
	
	private Board board; // chamou o tabuleiro
	
	public ChessMatch() {         // construtor padrão
		board = new Board(8, 8);          // o board vai receber 8,8. Quem tem que saber a dimensão do tabuleiro é a classe chessmatch
		initialSetup();
	}
	
	public ChessPiece[][] getpieces() {           // vai retornar uma matriz de peças de xadres / foi acrecentado no Program junto com a classe UI
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];// estanciando o tabuleiro no ChessPiece
		for(int i=0; i<board.getRows(); i++) {         // desenvolvimento em camadas, apenas a camada do ChessPiece estara exposta(não estara exposta a camada do tabuleiro  
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);// (ChessPiece) uma peça de xadres, não uma peça comum
			}
		}
		return mat;
	}
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position (2,1));
		board.placePiece(new King(board, Color.BLACK), new Position (0,4));
		board.placePiece(new King(board, Color.WHITE), new Position (7,4));
	}

}
