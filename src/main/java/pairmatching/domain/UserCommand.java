package pairmatching.domain;

import pairmatching.enums.CommandType;

public class UserCommand {
    private final String command;

    public UserCommand(String input) {
        validateCommandType(input);
        this.command = input;
    }

    private void validateCommandType(String codeName) throws IllegalArgumentException{
        CommandType.selectCommandByCodeName(codeName);
    }

    public String getCommand() {
        return command;
    }
}
