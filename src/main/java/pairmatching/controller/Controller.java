package pairmatching.controller;

import pairmatching.domain.*;

import java.util.List;

import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

public class Controller {
    private boolean isStop = false;
    public void run() {
        PairMatchingProgram pairMatchingProgram = new PairMatchingProgram();
        while (!isStop) {
            ExecuteCommand(inputUserCommand(), pairMatchingProgram);
        }
    }

    private UserCommand inputUserCommand() {
        while(true) {
            try {
                return new UserCommand(readProgramCommand());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void ExecuteCommand(UserCommand command, PairMatchingProgram pairMatchingProgram) {
        if (command.getCommand().equals("1")) {
            executePairMatching(pairMatchingProgram);
        }
        if (command.getCommand().equals("2")) {

        }
        if (command.getCommand().equals("2")) {

        }
        if (command.getCommand().equals("Q")) {
            this.isStop = true;
        }
    }

    public void executePairMatching(PairMatchingProgram pairMatchingProgram) {
        UserOptionCommand userOptionCommand = inputUserOptions();
        try {
            if (pairMatchingProgram.checkIsExistResult(userOptionCommand)) {
                UserRematchingCommand rematchingCommand = inputRematchingCommand();
                if (!rematchingCommand.getIsRematching()) {
                    //출력
                    return;
                }
            }
            List<List<String>> result = pairMatchingProgram.runPairMatching(userOptionCommand);
            printPairMatchingResult(result);
            return;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private UserOptionCommand inputUserOptions() {
        while(true) {
            try {
                return new UserOptionCommand(readCourseAndLevelAndMission());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private UserRematchingCommand inputRematchingCommand() {
        while(true) {
            try {
                return new UserRematchingCommand(readRematching());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
