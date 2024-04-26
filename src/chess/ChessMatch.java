package chess;

import boardgame.Board;

public class ChessMatch {
	
	private Board board; // chamou o tabuleiro
	
	public ChessMatch() { // construtor padrão
		board = new Board(8, 8); // o board vai receber 8,8. Quem tem que saber a dimensão do tabuleiro é a classe chessmatch
	}
	
	public ChessPiece[][] getpieces() { // vai retornar uma matriz de peças de xadres / foi acrecentado no Program junto com a classe UI
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];// estanciando o tabuleiro no ChessPiece
		for(int i=0; i<board.getRows(); i++) { // desenvolvimento em camadas, apenas a camada do ChessPiece estara exposta(não estara exposta a camada do tabuleiro  
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);// (ChessPiece) uma peça de xadres, não uma peça comum
			}
		}
		return mat;
	}

}
