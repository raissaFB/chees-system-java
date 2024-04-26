package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece{
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() { // método get (pegar), por sua vez, é utilizado para obter e retornar o valor “setado”
		return color;
	}

	
	

}
