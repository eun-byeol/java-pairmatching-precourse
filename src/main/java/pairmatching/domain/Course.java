package pairmatching.domain;

import pairmatching.enums.CourseType;

import java.util.List;

public class Course {
    private final List<String> crewNames;
    private final String courseName;

    public Course(List<String> crewNames, String courseName) {
        this.crewNames = crewNames;
        validateCourseType(courseName);
        this.courseName = courseName;
    }

    private void validateCourseType(String courseName) throws IllegalArgumentException{
        CourseType.selectCourseByName(courseName);
    }
}
