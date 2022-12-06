package pairmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.domain.PairMatchingChecker;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PairMatchingCheckerTest {
    List<List<String>> prev = Arrays.asList(
            Arrays.asList("용팔", "대만"),
            Arrays.asList("대협", "덕규"),
            Arrays.asList("치수", "준호")
    );
    List<List<String>> cur = Arrays.asList(
            Arrays.asList("태웅", "백호"),
            Arrays.asList("달재", "태산"),
            Arrays.asList("대만", "덕규")
    );

    @DisplayName("중복 원소 여부 확인하기")
    @Test
    void checkDuplicationTest() {
        assertThat(new PairMatchingChecker().isDuplicate(prev, cur)).isFalse();
    }
}
