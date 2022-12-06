package pairmatching.controller;

import pairmatching.domain.PairMatchingProgram;
import pairmatching.domain.UserCommand;

import static pairmatching.view.InputView.readCourseAndLevelAndMission;
import static pairmatching.view.InputView.readProgramCommand;

public class Controller {
    public void run() {
        PairMatchingProgram pairMatchingProgram = new PairMatchingProgram();

        UserCommand command = new UserCommand(readProgramCommand());
        String userInput = readCourseAndLevelAndMission();
        String[] inputs = userInput.split(", ");
        for (String input : inputs) {
        }
    }
}
