package chess;

import boardgame.Board;
import boardgame.Piece;
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
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
	if (!board.thereIsAPiece(position)) {
		throw new ChessException("There is no piece on source position");
	}
}
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new  ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}

}
