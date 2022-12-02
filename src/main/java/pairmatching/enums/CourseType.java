package pairmatching.enums;

import java.util.Arrays;

import static pairmatching.utils.ErrorMessages.*;

public enum CourseType {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    CourseType(String name) {
        this.name = name;
    }

    public static CourseType selectCourseByName(String courseName) {
        return Arrays.stream(CourseType.values())
                .filter(course -> course.name.equals(courseName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(COURSE_NOT_OPTIONS));
    }
}
