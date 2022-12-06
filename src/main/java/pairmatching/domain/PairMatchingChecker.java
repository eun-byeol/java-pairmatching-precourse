package pairmatching.domain;

import java.util.List;
import java.util.TreeSet;

public class PairMatchingChecker {
    public boolean checkDuplication(Level level, List<List<String>> matchingResult) {
        for (String key : level.getMissions().keySet()) {
            if (isDuplicateResultInMission(level.getMissions().get(key), matchingResult)) {
                return false;
            }
        }
        return true;
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

//    public static void main(String[] args) {
//        List<List<String>> prev = Arrays.asList(
//                Arrays.asList("용팔", "대만"),
//                Arrays.asList("대협", "덕규"),
//                Arrays.asList("치수", "준호")
//        );
//        List<List<String>> cur = Arrays.asList(
//                Arrays.asList("태웅", "백호"),
//                Arrays.asList("달재", "태산"),
//                Arrays.asList("대만", "덕규")
//        );
//        System.out.println(new PairMatchingChecker().isDuplicate(prev, cur));
//    }
}
