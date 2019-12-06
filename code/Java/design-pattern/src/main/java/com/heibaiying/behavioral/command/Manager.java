package com.heibaiying.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class Manager {

	private List<Command> commandList = new ArrayList<>();

	public void addCommand(Command command) {
		commandList.add(command);
	}

	public void executeCommands() {
		for (Command command : commandList) {
			command.execute();
		}
		commandList.clear();
	}
}
