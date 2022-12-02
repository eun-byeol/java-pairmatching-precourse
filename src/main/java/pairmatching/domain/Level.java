package pairmatching.domain;

import pairmatching.enums.LevelType;

public class Level {
    private final String levelName;
    public Level(String levelName) {
        validateLevelType(levelName);
        this.levelName = levelName;
    }

    private void validateLevelType(String name) throws IllegalArgumentException{
        LevelType.selectLevelTypeByName(name);
    }
}
