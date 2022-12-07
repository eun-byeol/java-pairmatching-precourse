package pairmatching.controller;

import pairmatching.domain.*;
import pairmatching.enums.CommandType;

import java.util.List;

import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

public class Controller {
    private PairMatchingProgram pairMatchingProgram;
    private boolean isStop = false;
    public void run() {
        this.pairMatchingProgram = new PairMatchingProgram();
        while (!isStop) {
            ExecuteCommand(inputUserCommand());
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

    private void ExecuteCommand(UserCommand command) {
        if (command.getCommand().equals(CommandType.PAIR_MATCHING.getCodeName())) {
            executePairMatching();
        }
        if (command.getCommand().equals(CommandType.PAIR_LOOKUP.getCodeName())) {
            executeLookUp();
        }
        if (command.getCommand().equals(CommandType.PAIR_RESET.getCodeName())) {
            executeReset();
        }
        if (command.getCommand().equals(CommandType.QUIT.getCodeName())) {
            this.isStop = true;
        }
    }

    public void executePairMatching() {
        UserOptionCommand userOptionCommand = inputUserOptions();
        try {
            if (pairMatchingProgram.checkIsExistResult(userOptionCommand)) {
                UserRematchingCommand rematchingCommand = inputRematchingCommand();
                if (!rematchingCommand.getIsRematching()) {
                    try {
                        printPairMatchingResult(pairMatchingProgram.pairLookUp(userOptionCommand));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    return;
                }
            }
            List<List<String>> result = pairMatchingProgram.runPairMatching(userOptionCommand);
            printPairMatchingResult(result);
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

    private void executeLookUp() {
        UserOptionCommand userOptionCommand = inputUserOptions();
        try {
            printPairMatchingResult(pairMatchingProgram.pairLookUp(userOptionCommand));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void executeReset() {
        this.pairMatchingProgram = new PairMatchingProgram();
        printProgramReset();
    }
}
