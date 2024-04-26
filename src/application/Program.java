package application;

import boardgame.Board;
import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getpieces()); // vai receber a matriz de peças da minha partida     
		
		
	}

}
