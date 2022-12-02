package pairmatching.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ReadFile {
    public static List<String> readFileAndReturnNameList(String pathName) throws IOException {
        List<String> crewNames = new ArrayList<>();
        Scanner scanner = new Scanner(new File(pathName));

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            crewNames.add(str);
        }
        return crewNames;
    }
}
