package com.qrobot;

/*Set the dimension where the robot is allowed to move*/
public class Dimension {

	private int maxX, maxY;
	private int minX, minY;

	/*Set default dimension*/
	public Dimension() {
		minX = 0;
		minY = 0;
		maxX = 5;
		maxY = 5;
	}
	
	public Dimension(int minX, int minY, int maxX, int maxY) {
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX; 
		this.maxY = maxY;
	}
	
	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public int getMinX() {
		return minX;
	}
	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}
	public void setMinY(int minY) {
		this.minY = minY;
	}
	
	
}
