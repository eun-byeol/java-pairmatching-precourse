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
        CourseType backend = CourseType.valueOf("BACKEND");
        CourseType frontend = CourseType.valueOf("FRONTEND");
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

    public List<List<String>> runPairMatching(String course, String level, String mission) throws Exception {
        int count = 0;
        Course currentCourse = selectCourseType(course);
        Level currentLevel = currentCourse.getLevels().get(level);
        Mission currentMission = currentLevel.getMissions().get(mission);
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

    private Course selectCourseType(String course) {
        if (CourseType.valueOf("BACKEND").getName().equals(course)) {
            return this.backendCourse;
        }
        return this.frontendCourse;
    }
}
