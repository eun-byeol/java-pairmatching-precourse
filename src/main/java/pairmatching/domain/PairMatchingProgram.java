package pairmatching.domain;

import pairmatching.enums.CourseType;
import pairmatching.utils.ReadFile;

import java.io.IOException;
import java.util.List;

import static pairmatching.utils.ErrorMessages.MATCHING_FAIL;

public class PairMatchingProgram {
    private Course backendCourse;
    private Course frontendCourse;

    private PairMatchingMaker pairMatchingMaker;
    private PairMatchingChecker pairMatchingChecker;

    public PairMatchingProgram() {
        CourseType backend = CourseType.BACKEND;
        CourseType frontend = CourseType.FRONTEND;
        try {
            this.backendCourse = new Course(
                    ReadFile.readFileAndReturnNameList(backend.getPath()),
                    backend
            );
            this.frontendCourse = new Course(
                    ReadFile.readFileAndReturnNameList(frontend.getPath()),
                    frontend
            );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        this.pairMatchingMaker = new PairMatchingMaker();
        this.pairMatchingChecker = new PairMatchingChecker();
    }

    public boolean checkIsExistResult(UserOptionCommand inputs) {
        Course currentCourse = selectCourseType(inputs.getCourse());
        Level currentLevel = currentCourse.getLevels().get(inputs.getLevel().getName());
        Mission currentMission = currentLevel.getMissions().get(inputs.getMission().getName());

        return pairMatchingChecker.isExistMatchingResult(currentMission);
    }

    public List<List<String>> runPairMatching(UserOptionCommand inputs) throws Exception {
        int count = 0;
        Course currentCourse = selectCourseType(inputs.getCourse());
        Level currentLevel = currentCourse.getLevels().get(inputs.getLevel().getName());
        Mission currentMission = currentLevel.getMissions().get(inputs.getMission().getName());
        List<String> crewNames = currentCourse.getCrewNames();

        while (count < 3) {
            List<List<String>> result = pairMatchingMaker.returnPairMatching(crewNames);
            if (!pairMatchingChecker.checkDuplication(currentLevel, result)) {
                currentMission.setMatchingResult(result);
                return result;
            }
            count++;
        }
        throw new Exception(MATCHING_FAIL);
    }

    private Course selectCourseType(CourseType course) {
        if (CourseType.BACKEND.equals(course)) {
            return this.backendCourse;
        }
        return this.frontendCourse;
    }
}
