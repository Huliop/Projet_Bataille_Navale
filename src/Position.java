
public class Position {

	// ================================================================================================
	// ATTRIBUTES
	// ================================================================================================
	private int line;
	private int row;
	
	// ================================================================================================
	// CONSTRUCTOR
	// ================================================================================================
	public Position(int x, int y) {
		this.line = x;
		this.row = y;
	}

	// ================================================================================================
	// PRIVATE FUNCTIONS
	// ================================================================================================
	private int moduloPosition(int i, int mod) {
		return (i%mod + mod)%mod;
	}

	private void move(int xDifference, int yDifference, int gameBoardSize) {
		line = moduloPosition(line + xDifference, gameBoardSize);
		row = moduloPosition(row + yDifference, gameBoardSize);
	}

	// ================================================================================================
	// PUBLIC FUNCTIONS
	// ================================================================================================
	public int getLine() {
		return this.line;
	}
	
	public int getRow() {
		return this.row;
	}

	public void moveUp(int gameBoardSize) {
		move(-1, 0, gameBoardSize);
	}

	public void moveDown(int gameBoardSize) {
		move(1, 0, gameBoardSize);
	}

	public void moveLeft(int gameBoardSize) {
		move(0, -1, gameBoardSize);
	}

	public void moveRight(int gameBoardSize) {
		move(0, 1, gameBoardSize);
	}

	public String toString() {
		return "("+this.line+", "+this.row+")";
	}

}
