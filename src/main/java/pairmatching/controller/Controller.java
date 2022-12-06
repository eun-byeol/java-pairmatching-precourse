package pairmatching.controller;

import pairmatching.domain.PairMatchingProgram;
import pairmatching.domain.UserCommand;

import java.util.ArrayList;
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
            System.out.println("1");
            String userInput = readCourseAndLevelAndMission();
            String[] inputs = userInput.split(",");
            List<String> inputList = new ArrayList<>();
            for (String input : inputs) {
                inputList.add(input.trim());
            }
            try {
                List<List<String>> result = pairMatchingProgram.runPairMatching(
                        inputList.get(0),
                        inputList.get(1),
                        inputList.get(2)
                );
                printPairMatchingResult(result);
                return;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        if (command.getCommand().equals("2")) {

        }
        if (command.getCommand().equals("2")) {

        }
        if (command.getCommand().equals("Q")) {
            this.isStop = true;
        }
    }
}
