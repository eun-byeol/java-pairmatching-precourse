package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairMatchingMaker {

    public List<List<String>> returnPairMatching(List<String> crewNames) {
        List<List<String>> result = new ArrayList<>();
        List<String> shuffledCrew = shuffleCrewNames(crewNames);

        groupingTwoCrews(result, shuffledCrew);
        addLastCrewIfOdd(result, shuffledCrew);

        return result;
    }

    public void groupingTwoCrews(List<List<String>> result, List<String> crewNames) {
        int crewNameIndex = 0;
        for (int i=0; i<crewNames.size() / 2; i++) {
            result.add(Arrays.asList(
                    crewNames.get(crewNameIndex++),
                    crewNames.get(crewNameIndex++)
            ));
        }
    }

    public void addLastCrewIfOdd(List<List<String>> result, List<String> crewNames) {
        if (isOddNumber(crewNames)) {
            int lastIndexOfResult = result.size() - 1;
            int lastIndexOfCrewNames = crewNames.size() - 1;

            List<String> lastOfResult = new ArrayList<>(result.get(lastIndexOfResult));
            String plus = crewNames.get(lastIndexOfCrewNames);
            lastOfResult.add(plus);
            result.set(lastIndexOfResult, lastOfResult);
        }
    }

    public boolean isOddNumber(List<String> crewNames) {
        return crewNames.size() % 2 != 0;
    }

    public List<String> shuffleCrewNames(List<String> crewNames) {
        return Randoms.shuffle(crewNames);
    }
}