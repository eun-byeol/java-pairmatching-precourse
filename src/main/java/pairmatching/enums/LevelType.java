package pairmatching.enums;

import java.util.Arrays;
import java.util.List;

import static pairmatching.utils.ErrorMessages.*;

public enum LevelType {
    LEVEL1("레벨1", Arrays.asList(
            MissionType.valueOf("CAR_RACING"),
            MissionType.valueOf("LOTTO"),
            MissionType.valueOf("BASEBALL")
    )),
    LEVEL2("레벨2", Arrays.asList(
            MissionType.valueOf("SHOPPING_BASKET"),
            MissionType.valueOf("PAYMENT"),
            MissionType.valueOf("SUBWAY_LINE")
    )),
    LEVEL3("레벨3", Arrays.asList()),
    LEVEL4("레벨4", Arrays.asList(
            MissionType.valueOf("PERFORMANCE_IMPROVEMENT"),
            MissionType.valueOf("DISTRIBUTE")
    )),
    LEVEL5("레벨5", Arrays.asList());

    private String name;
    private List<MissionType> missions;

    LevelType(String name, List<MissionType> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static LevelType selectLevelTypeByName(String name) {
        return Arrays.stream(LevelType.values())
                .filter(level -> level.name.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(LEVEL_NOT_OPTIONS));
    }

    public String getName() {
        return name;
    }

    public List<MissionType> getMissions() {
        return missions;
    }
}