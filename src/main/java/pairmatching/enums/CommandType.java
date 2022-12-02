package pairmatching.enums;

import java.util.Arrays;
import static pairmatching.utils.ErrorMessages.*;

public enum CommandType {
    PAIR_MATCHING("1", "페어 매칭"),
    PAIR_LOOKUP("2", "페어 조회"),
    PAIR_RESET("3", "페어 초기화"),
    QUIT("Q", "종료");

    private String codeName;
    private String subject;

    CommandType(String codeName, String subject) {
        this.codeName = codeName;
        this.subject = subject;
    }

    public static CommandType selectCommandByCodeName(String codeName) {
        return Arrays.stream(CommandType.values())
                .filter(command -> command.codeName.equals(codeName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(COMMAND_NOT_OPTIONS));
    }

    public String getCodeName() {
        return codeName;
    }
}