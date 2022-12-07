package pairmatching.domain;

import pairmatching.enums.RematchingCommandType;

public class UserRematchingCommand {
    private final boolean isRematching;

    public UserRematchingCommand(String input) {
        this.isRematching = validateRematchingCommandType(input.trim());
    }

    private boolean validateRematchingCommandType(String input) throws IllegalArgumentException {
        return RematchingCommandType.selectRematchingCommandByCommand(input)
                                .getIsRematching();
    }

    public boolean getIsRematching() {
        return isRematching;
    }
}
