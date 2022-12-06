package pairmatching.view;

import java.util.List;

import static pairmatching.utils.ViewMessages.*;

public class OutputView {
    public static void printPairMatchingResult(List<List<String>> result) {
        System.out.println(OUTPUT_MATCHING_RESULT);
        for (List<String> pair : result) {
            String pairNames = String.join(OUTPUT_SEPARATOR, pair);
            System.out.println(pairNames);
        }
        System.out.println();
    }
}