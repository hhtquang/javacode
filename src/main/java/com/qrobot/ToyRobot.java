package com.qrobot;

import java.util.ArrayList;
import java.util.List;


public class ToyRobot {

    private Moving direction;
	private Position position;
	private Dimension dimension;
    private List<Command> commands;
	
	public ToyRobot() {
		commands = new ArrayList<Command>();
		
		//initiate 5x5 
		Dimension dimension = new Dimension(0, 0, 4, 4); 
		this.dimension = dimension;
		
	}
	
	
	public void move() {
		if (this.dimension == null) return; 
		if (position == null) return;
		if (direction == null) return;
		
		Position lookAhead = position.copy();
		if (direction == Moving.NORTH) 
			lookAhead.increaseY();
		if (direction == Moving.EAST) 
			lookAhead.increaseX();
		if (direction == Moving.SOUTH) 
			lookAhead.decreaseY();
		if (direction == Moving.WEST) 
			lookAhead.decreaseX();
		if (validatePosition(lookAhead)) 
			this.position = lookAhead;
	}
	
	
	public void place(int x, int y) {
		if (dimension == null) return; 
		Position lookAhead = new Position(x, y);
		this.place(lookAhead);
	}
	
	public void place(Position pos) {
		
		if (dimension == null) return; 
		if (validatePosition(pos)) this.position = pos;
	}
	
	/*Move inside the boundaries*/
	boolean validatePosition(Position pos) {
		if (pos.getX() < dimension.getMinX()) return false;
		if (pos.getX() > dimension.getMaxX()) return false;
		
		if (pos.getY() < dimension.getMinY()) return false;
		if (pos.getY() > dimension.getMaxY()) return false;
		
		return true;
	}
	
	public void setHeading(Moving x) {
		if (x != null) this.direction = x;
	}
	 
	
	public void performCommand(Command cmd) {
		if (cmd.getAction() == CommandAction.LEFT) 
			direction = direction.turnLeft();
		if (cmd.getAction() == CommandAction.RIGHT)
			direction = direction.turnRight();
		if (cmd.getAction() == CommandAction.MOVE)	
			this.move();
		if (cmd.getAction() == CommandAction.REPORT) 
			System.out.println(this.toString());	
		if (cmd.getAction() == CommandAction.PLACE) {
			Moving dir = Moving.valueOf(cmd.getParam(2)); //0,0,NORTH ->return NORTH
			int x = cmd.getParamAsInt(0);
			int y = cmd.getParamAsInt(1);
			this.direction = dir;
			this.place(x, y);
		}
		
	}
	
	public Position getPosition() {
		return position;
	}
	
	
	public String toString() {
		StringBuilder buffer= new StringBuilder("");
		if (position != null) buffer.append(position.toString());
		buffer.append(",");
		if (direction != null) buffer.append(direction.toString());
		return buffer.toString();
	}
	
	//This is to perform according to the commmands and set flag isPlaced
	public void doCommands() {
		boolean isPlaced = false;
		for (Command cmd : commands) {
			if ((cmd.getAction() == CommandAction.PLACE)  || (isPlaced)) {
				this.performCommand(cmd);
				if (!isPlaced) {
					isPlaced = true;
				}
					
			}
		}
		
	}
	
	public void add(Command com) {
		commands.add(com);
	}


	public void setCommands(List<Command> x) {
		commands = x;
	}
	
}
