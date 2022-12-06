package pairmatching.domain;

import java.util.List;
import java.util.TreeSet;

public class PairMatchingChecker {
    public boolean checkDuplication(Level level, List<List<String>> matchingResult) {
        for (String key : level.getMissions().keySet()) {
            if (isDuplicateResultInMission(level.getMissions().get(key), matchingResult)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicateResultInMission(Mission mission, List<List<String>> matchingResult) {
        if (!mission.isMatching()) {
            return false;
        }
        List<List<String>> previousResult = mission.getMatchingResult();
        return isDuplicate(previousResult, matchingResult);
    }

    public boolean isDuplicate(List<List<String>> previous, List<List<String>> current) {
        for (List<String> previousPair : previous) {
            TreeSet<String> prevPairTree = new TreeSet<>(previousPair);
            for (List<String> currentPair : current) {
                TreeSet<String> curPairTree = new TreeSet<>(currentPair);
                if (prevPairTree.equals(curPairTree)) {
                    return true;
                }
            }
        }
        return false;
    }
}
