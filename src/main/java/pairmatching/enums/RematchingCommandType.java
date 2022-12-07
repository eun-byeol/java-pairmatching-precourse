package pairmatching.enums;

import java.util.Arrays;

import static pairmatching.utils.ErrorMessages.*;

public enum RematchingCommandType {
    YES("예", true),
    NO("아니오", false);

    private String command;
    private boolean isRematching;

    RematchingCommandType(String command, boolean isRematching) {
        this.command = command;
        this.isRematching = isRematching;
    }

    public static RematchingCommandType selectRematchingCommandByCommand(String command) {
        return Arrays.stream(RematchingCommandType.values())
                .filter(RematchingCommand -> RematchingCommand.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(REMATCHING_COMMAND_NOT_OPTIONS));
    }

    public boolean getIsRematching() {
        return isRematching;
    }
}
