package pairmatching.enums;

import java.util.Arrays;
import static pairmatching.utils.ErrorMessages.*;

public enum Command {
    PAIR_MATCHING("1", "페어 매칭"),
    PAIR_LOOKUP("2", "페어 조회"),
    PAIR_RESET("3", "페어 초기화"),
    QUIT("Q", "종료");

    private String codeName;
    private String subject;

    Command(String codeName, String subject) {
        this.codeName = codeName;
        this.subject = subject;
    }

    public static Command selectCommandByCodeName(String codeName) {
        return Arrays.stream(Command.values())
                .filter(command -> command.codeName.equals(codeName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(GAME_COMMAND_NOT_OPTIONS));
    }

    public String getCodeName() {
        return codeName;
    }
}