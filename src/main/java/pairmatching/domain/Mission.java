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

    public void setMatchingResult(List<List<String>> matchingResult) {
        this.matchingResult = matchingResult;
        this.isMatching = true;
    }

    public boolean getIsMatching() {
        return isMatching;
    }

    public List<List<String>> getMatchingResult() {
        return matchingResult;
    }
}
