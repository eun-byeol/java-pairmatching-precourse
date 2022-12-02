package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.utils.ReadFile;

import java.io.IOException;

public class Controller {
    private static final String PATH_NAME_OF_BACKEND_CREW = "/Users/jo-eunbyeol/wooteco/java-pairmatching-precourse/src/main/resources/backend-crew.md";
    private static final String PATH_NAME_OF_FRONTEND_CREW = "/Users/jo-eunbyeol/wooteco/java-pairmatching-precourse/src/main/resources/frontend-crew.md";
    private static final String BACKEND = "백엔드";
    private static final String FRONTEND = "프론트엔드";

    public void programSetting() {
        try {
            Course BackendCourse = new Course(ReadFile.readFileAndReturnNameList(PATH_NAME_OF_BACKEND_CREW), BACKEND);
            Course FrontendCourse = new Course(ReadFile.readFileAndReturnNameList(PATH_NAME_OF_FRONTEND_CREW), BACKEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
