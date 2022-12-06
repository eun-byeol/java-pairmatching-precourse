package pairmatching.domain;

import pairmatching.enums.CourseType;
import pairmatching.utils.ReadFile;

import java.io.IOException;

public class PairMatchingProgram {
    private Course backendCourse;
    private Course frontendCourse;

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
    }
}
