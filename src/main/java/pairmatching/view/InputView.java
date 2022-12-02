package pairmatching.view;

import static pairmatching.utils.ViewMessages.*;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readProgramCommand() {
        System.out.println(INPUT_PROGRAM_COMMAND);
        return Console.readLine();
    }

    public static String readCourseAndLevelAndMission() {
        System.out.println(INPUT_COURSE_AND_MISSION);
        System.out.println(INPUT_COURSE_LEVEL_MISSION);
        return Console.readLine();
    }

    public static String readRematching() {
        System.out.println(INPUT_REMATCHING);
        return Console.readLine();
    }
}
