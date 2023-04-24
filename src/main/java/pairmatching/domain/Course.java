package pairmatching.domain;

import pairmatching.enums.CourseType;
import pairmatching.enums.LevelType;

import java.util.HashMap;
import java.util.List;

public class Course {
    private HashMap<String, Level> levels;
    private final List<String> crewNames;
    private final CourseType courseType;

    public Course(List<String> crewNames, CourseType courseType) {
        this.levels = new HashMap<>();
        setUpLevels();
        this.crewNames = crewNames;
        this.courseType = courseType;
    }

    private void setUpLevels() {
        for (LevelType leveltype : LevelType.values()) {
            this.levels.put(leveltype.getName(), new Level(leveltype));
        }
    }

    public List<String> getCrewNames() {
        return crewNames;
    }

    public HashMap<String, Level> getLevels() {
        return levels;
    }

    //    private void validateCourseType(CourseType courseName) throws IllegalArgumentException{
//        CourseType.selectCourseByName(courseName);
//    }
}