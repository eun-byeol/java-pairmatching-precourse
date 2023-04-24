package pairmatching.enums;

import java.util.Arrays;

import static pairmatching.utils.ErrorMessages.*;

public enum CourseType {
    BACKEND("백엔드", "/Users/jo-eunbyeol/wooteco/java-pairmatching-precourse/src/main/resources/backend-crew.md"),
    FRONTEND("프론트엔드", "/Users/jo-eunbyeol/wooteco/java-pairmatching-precourse/src/main/resources/frontend-crew.md");

    private String name;
    private String path;

    CourseType(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public static CourseType selectCourseByName(String courseName) {
        return Arrays.stream(CourseType.values())
                .filter(course -> course.name.equals(courseName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(COURSE_NOT_OPTIONS));
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
