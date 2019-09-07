package com.qrobot;

/*Holding postition of the Robot*/

public class Position {
	private int x,y;

	public Position() {
		x = 0;
		y = 0;
	}
	
	public Position(int x, int y) {
		this.x = x; 
		this.y = y;
	}
	
	public Position copy() {
		return new Position(this.x, this.y);
	}

	public void increaseY() {
		y++;
		
	}

	public void increaseX() {
		x++;
		
	}

	public void decreaseY() {
		y--;
		
	}

	public void decreaseX() {
		x--;
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public String toString() {
		return x + "," + y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Position) {
			Position toTest = (Position) obj;
			if ((toTest.getX() == this.x) && (toTest.getY() == this.y)) return true;
		}
		return false;
	}
	
	
	
	
}
