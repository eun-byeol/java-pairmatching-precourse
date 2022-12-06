package pairmatching.domain;

import pairmatching.enums.LevelType;
import pairmatching.enums.MissionType;

import java.util.HashMap;
import java.util.List;

public class Level {
    private final LevelType levelType;
    private HashMap<String, Mission> missions;

    public Level(LevelType levelType) {
        this.levelType = levelType;
        this.missions = new HashMap<>();
        setUpMissions();
//        validateLevelType(levelType);
    }

    private void setUpMissions() {
        List<MissionType> missionTypes = this.levelType.getMissions();
        for (MissionType missionType: missionTypes) {
            this.missions.put(missionType.getName(), new Mission(missionType));
        }
    }

//    private void validateLevelType(String name) throws IllegalArgumentException{
//        LevelType.selectLevelTypeByName(name);
//    }
}
