package com.qrobot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RobotCreator {
    
	//create an list of robots
	private Map<String, ToyRobot> robots = new HashMap<String,ToyRobot>();
	
	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out.println("Usage: java -jar QToyRobot-0.0.1-SNAPSHOT.jar <input file>");
			return;
		}
		
		//create the robot and give him a list of command 
		RobotCreator robot = new RobotCreator(args[0]);
		robot.work();
		
	}
	
	
	public RobotCreator(String commandFile) {
		ToyRobot robot = new ToyRobot();
		robots.put("1",robot);
		
		CommandReader cmdReader = new CommandReader();
		
		Map<String, List<Command>> result = cmdReader.readFile(commandFile);
		
		for (String rbid: result.keySet()) {
			if (robots.containsKey(rbid) ) {
				robots.get(rbid).setCommands(result.get(rbid));
			}
		}
		
	}
	
	public void work() {
		for (ToyRobot robot: robots.values()) {
			robot.doCommands();
		}
	}
	
	
	
	

}
