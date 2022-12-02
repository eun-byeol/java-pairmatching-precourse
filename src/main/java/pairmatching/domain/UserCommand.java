package pairmatching.domain;

import pairmatching.enums.Command;

public class UserCommand {
    private final String command;

    public UserCommand(String input) {
        validateCommandType(input);
        this.command = input;
    }

    private void validateCommandType(String codeName) throws IllegalArgumentException{
        Command.selectCommandByCodeName(codeName);
    }

    public String getCommand() {
        return command;
    }
}
