package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	
	public String toString() {
		
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		
		
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// Above
		
		p.setValue(position.getRow() - 1, position.getColumn());
		
	    while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p))
	    {
	    			
	     mat[p.getRow()][p.getColumn()] = true;
	     p.setRow(p.getRow() - 1);
	    }
	    
	    if(getBoard().positionExists(p) && isThereOpponentPiece(p))
	    {
	    	 mat[p.getRow()][p.getColumn()] = true;
	    }
	    
	    //Left 
	    
	    p.setValue(position.getRow(), position.getColumn() -1);
		
	    while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p))
	    {
	    		
	     mat[p.getRow()][p.getColumn()] = true;
	     p.setColumn(p.getColumn() - 1);
	    }
	    
	    if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
	    	 mat[p.getRow()][p.getColumn()] = true;
	    }
		
	    //Right
	    
	    p.setValue(position.getRow(), position.getColumn() + 1);
		
	    while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p))	    {
	     mat[p.getRow()][p.getColumn()] = true;
	     p.setColumn(p.getColumn() + 1);
	    }
	    
	    if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
	    	 mat[p.getRow()][p.getColumn()] = true;
	    }
		
	    // Below
	    
	    p.setValue((position.getRow() + 1), position.getColumn());
		
	    while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
	     mat[p.getRow()][p.getColumn()] = true;
	     p.setRow(p.getRow() + 1);
	    }
	    
	    if(getBoard().positionExists(p) && isThereOpponentPiece(p))
	    {
	    	 mat[p.getRow()][p.getColumn()] = true;
	    }
		
		/*
		for(int i=0;i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				System.out.printf(mat[i][j] + " ");
				
			}
			System.out.println();
		}
		System.out.println();
		*/
	  return mat;
	
	}
}