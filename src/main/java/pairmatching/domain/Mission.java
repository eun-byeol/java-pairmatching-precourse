package pairmatching.domain;

import pairmatching.enums.MissionType;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    private final MissionType missionType;
    private boolean isMatching;
    private List<List<String>> matchingResult;

    public Mission(MissionType missionType) {
        this.missionType = missionType;
        this.isMatching = false;
        this.matchingResult = new ArrayList<>();
    }
}
