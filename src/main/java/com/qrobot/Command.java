package com.qrobot;


//if command = PLACE 0,0,NORTH then Command stores action = PLACE and params = 0,0,NORTH
public class Command {
	
	CommandAction action;
	String[] params;

	public Command() {
		action = CommandAction.NULL;
		params = null;
	}
	
	public Command(CommandAction action, String[] params) {
		this.action = action;
		this.params = params;
	}

	public CommandAction getAction() {
		return action;
	}
    
	//0,0,NORTH
	public String getParam(int idx) {
		if ((idx >= 0) && (idx < params.length)) return params[idx];
		return null;
	}
	
	
	public int getParamAsInt(int idx) {
		String tmp = getParam(idx);
		if (tmp == null) return 0;
		else return Integer.parseInt(tmp);
	}
	
	
	public String toString() {
		StringBuilder buffer= new StringBuilder(action.toString());
		if (params != null) {
			buffer.append("[");
			for (String x: params) {
				buffer.append(x).append(",");
			}
			buffer.append("]");
		}
		return buffer.toString();
	}
	
}
