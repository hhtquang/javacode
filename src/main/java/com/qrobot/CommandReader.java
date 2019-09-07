package com.qrobot;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommandReader {


	public CommandReader() {
		
	}
	
	//PLACE 0,0,NORTH 
		//this function parse the line in the input command file and store it in the Command object
		Command readCommand(String src) { 
			if (src == null) return null;
			String[] arr = src.split("[ ,]+");
			
			CommandAction action = CommandAction.valueOf(arr[0]); //=PLACE
			if (action != null) {
				String[] params = Arrays.copyOfRange(arr,1,arr.length); // = 0,0,NORTH
				return new Command(action, params);
			}
			return null;
		}
		
	public Map<String, List<Command>> readFile(String path) {
		//Store a list of command read from the input files for each Robot
		//this HashMap is able to store multiple Robots 
		Map<String, List<Command>> result = new HashMap<String, List<Command>>();
		String currentRobot= "1";
		try {
			List<String> lines = Files.readAllLines(Paths.get(path));
			
			for (String line: lines) {
				if ((line != null) && (!line.equals(""))) {
					Command cmd = readCommand(line);
					
					List<Command> commandList = result.get(currentRobot);
					
					if (commandList == null) {
						commandList = new ArrayList<Command>();
					}
					commandList.add(cmd); //add each Commmand to the List of command 
					
					//add Robot and the list of command given to him into the HashMap
					result.put(currentRobot, commandList); 
					
				}
			}
		} catch (IOException e) {
			System.out.println("Error processing command file");
			e.printStackTrace();
		}
		return result;
	}
	
	
	
}
