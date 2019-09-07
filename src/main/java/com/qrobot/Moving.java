package com.qrobot;


public enum Moving {
	
	//assign values to the direction 
    NORTH(0),  EAST (90), SOUTH(180),  WEST(270);
	
	private int degrees; 
	
	private Moving(int deg) {
		degrees = deg;
	}
	
	public int getDegrees() {
		return degrees;
	}
	
	public Moving turnRight() {
		int tmp = degrees + 90 ;
		if (tmp == 360) tmp = 0;
		return Moving.getDirection(tmp);
	}
	
	public Moving turnLeft() {
		int tmp = degrees - 90;
		if (tmp < 0) tmp = 360 + tmp;
		return Moving.getDirection(tmp);
	}
	
	public static Moving getDirection(int deg) {
		if (deg == 0) return Moving.NORTH;
		if (deg == 90) return Moving.EAST;
		if (deg == 180) return Moving.SOUTH;
		if (deg == 270) return Moving.WEST;
		return null;
	}
	
}
