package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		
		while(! chessMatch.getCheckMate()) {
			
			try {
	    	UI.clearScreen();
			UI.printMatch(chessMatch, captured);
			System.out.println();
			System.out.println("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			boolean[][] possibleMoves = chessMatch.possibleMoves(source);
			UI.clearScreen();
			UI.printBoard(chessMatch.getPiece(), possibleMoves);
			
			System.out.println();
			System.out.println("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			if(chessMatch.getCheck()) {
				System.out.println("CHECK!");
			}
		
			if( capturedPiece!= null ) {
				captured.add(capturedPiece);
				}
			if(chessMatch.getPromoted() != null) {
				System.out.print("Enter piece for promoted (R/Q/N/B) : ");
				String type = sc.nextLine().toUpperCase();
				while(!type.equals("B") && !type.equals("Q") && !type.equals("R") && !type.equals("N")){
					System.out.print("Enter piece for promoted (R/Q/N/B) : ");
					type = sc.nextLine().toUpperCase();
				}
				chessMatch.replacePromotedPiece(type);
				
			}
			}
			catch(ChessException e)
			{
				System.out.println(e.getMessage());
				sc.nextLine();
				
			}
			catch(InputMismatchException e)
			{
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
			}
		
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}
