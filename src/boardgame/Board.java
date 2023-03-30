package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece [][]pieces;
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			
			throw new BoardException("Error Creating Board: there must be at least 1 row and 1 column");
		}
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece [rows][columns];
		
	}
	public int getRows() {
		return rows;
	}
	
	public int getColumn() {
		return columns;
	}
	
	
	public Piece piece (int row, int column) {
		if (!positionsExists(row,column)) {
			throw new BoardException("position not on the board");
		}
		return pieces [row][column];
	} 
	
	public Piece piece (Position position) {
		if (!positionsExists(position)) {
			throw new BoardException("position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
		
	}
	
	public void placePiece(Piece piece, Position position) {
		
		/*if (thereIsAPiece(position)) {
			throw new BoardException("ther is alredy a piece on position "+ position);*/
		
		pieces[position.getRow()][position.getColumn()]= piece;	
		piece.position = position;
			
			
		}
		
	
	
	
	public boolean positionsExists(int row,int column){
		return row >= 0 && row <rows && column >= 0 && column < columns;
		
	}
	public boolean positionsExists(Position position){
		
		return positionsExists(position.getRow(),position.getColumn());
	}
		public boolean thereIsAPiece(Position position) {
			
			if (!positionsExists(position)) {
				throw new BoardException("position not on the board");
			}
		return piece(position)!= null;
		
	} 
}
