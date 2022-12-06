package pairmatching.domain;

import pairmatching.enums.CourseType;

public class Crew {
    private CourseType courseType;
    private String name;

    public Crew(CourseType courseType, String name) {
        this.courseType = courseType;
        this.name = name;
    }
}
