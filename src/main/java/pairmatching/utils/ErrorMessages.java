package pairmatching.utils;

public class ErrorMessages {
    private static final String ERROR_TAG = "[ERROR] ";
    public static final String COMMAND_NOT_OPTIONS = ERROR_TAG + "1~3 혹은 Q 중 하나의 문자여야 합니다.";
    public static final String COURSE_NOT_OPTIONS = ERROR_TAG + "백엔드, 프론트엔드 중 하나의 단어여야 합니다.";
    public static final String LEVEL_NOT_OPTIONS = ERROR_TAG + "레벨1~5 중 하나의 정확한 단어여야 합니다.";
    public static final String MISSION_NOT_OPTIONS = ERROR_TAG + "유효하지 않은 미션 이름입니다.";
    public static final String REMATCHING_COMMAND_NOT_OPTIONS = ERROR_TAG + "예, 아니오 중 하나의 단어야야 합니다.";
    public static final String MATCHING_FAIL = ERROR_TAG + "3회 이상 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없습니다.";
}
