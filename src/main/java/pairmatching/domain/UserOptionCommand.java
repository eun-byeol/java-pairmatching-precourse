package pairmatching.domain;

import pairmatching.enums.CourseType;
import pairmatching.enums.LevelType;
import pairmatching.enums.MissionType;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.utils.ErrorMessages.*;

public class UserOptionCommand {
    private final CourseType course;
    private final LevelType level;
    private final MissionType mission;

    private static final String SPLIT_SEPARATOR = ",";

    public UserOptionCommand(String input) {
        String[] splitInputs = input.split(SPLIT_SEPARATOR);
        List<String> inputs = new ArrayList<>();

        for (String option : splitInputs) {
            inputs.add(option.trim());
        }

        this.course = validateCourseType(inputs.get(0));
        this.level = validateLevelType(inputs.get(1));
        this.mission = validateMissionType(inputs.get(2));
    }

    private CourseType validateCourseType(String input) throws IllegalArgumentException{
        return CourseType.selectCourseByName(input);
    }

    private LevelType validateLevelType(String input) throws IllegalArgumentException{
        return LevelType.selectLevelTypeByName(input);
    }

    private MissionType validateMissionType(String input) throws IllegalArgumentException{
        List<MissionType> missions = level.getMissions();
        for (MissionType mission : missions) {
            if (mission.getName().equals(input)) {
                return mission;
            }
        }
        throw new IllegalArgumentException(MISSION_NOT_OPTIONS);
    }

    public CourseType getCourse() {
        return course;
    }

    public LevelType getLevel() {
        return level;
    }

    public MissionType getMission() {
        return mission;
    }
}
