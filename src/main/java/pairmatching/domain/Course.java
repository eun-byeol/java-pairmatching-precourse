package pairmatching.domain;

import java.util.List;

public class Course {
    private final List<String> crewNames;
    private final String name;

    public Course(List<String> crewNames, String name) {
        this.crewNames = crewNames;
        this.name = name;
    }
}
