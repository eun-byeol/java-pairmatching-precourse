package pairmatching.domain;

import pairmatching.enums.CourseType;
import pairmatching.utils.ReadFile;

import java.io.IOException;
import java.util.List;

import static pairmatching.utils.ErrorMessages.*;

public class PairMatchingProgram {
    private Course backendCourse;
    private Course frontendCourse;

    private PairMatchingMaker pairMatchingMaker;
    private PairMatchingChecker pairMatchingChecker;

    private Course currentCourse;
    private Level currentLevel;
    private Mission currentMission;

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

    private void setCurrent(UserOptionCommand inputs) {
        this.currentCourse = selectCourseType(inputs.getCourse());
        this.currentLevel = currentCourse.getLevels().get(inputs.getLevel().getName());
        this.currentMission = currentLevel.getMissions().get(inputs.getMission().getName());
    }

    private Course selectCourseType(CourseType course) {
        if (CourseType.BACKEND.equals(course)) {
            return this.backendCourse;
        }
        return this.frontendCourse;
    }

    public boolean checkIsExistResult(UserOptionCommand inputs) {
        setCurrent(inputs);
        return pairMatchingChecker.isExistMatchingResult(currentMission);
    }

    public List<List<String>> runPairMatching(UserOptionCommand inputs) throws Exception {
        int count = 0;
        setCurrent(inputs);
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

    public List<List<String>> pairLookUp(UserOptionCommand inputs) throws Exception {
        if (checkIsExistResult(inputs)) {
            return currentMission.getMatchingResult();
        }
        throw new Exception(NO_MATCHING_HISTORY);
    }
}
