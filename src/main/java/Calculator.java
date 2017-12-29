import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private static final String APPLY = "apply";
    private static final String ADD = "add";
    private static final String MULTIPLY = "multiply";
    private static final String DEVIDE = "devide";
    private static final String SUBSTRACT = "substract";

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);
        List<String> fileLines = new ArrayList<>();
        int total = 0;

        while (scanner.hasNextLine()) {
            fileLines.add(scanner.nextLine());
        }
        if (!fileLines.isEmpty()) {
            int currentTotal = calculateTotalFromLine(fileLines.get(fileLines.size() - 1).split(" "), total);
            for (int i = 0; i < fileLines.size() - 1; i++) {
                currentTotal = calculateTotalFromLine(fileLines.get(i).split(" "), currentTotal);
            }
            total = currentTotal;
        }
        System.out.println(total);
    }

    private static int calculateTotalFromLine(String[] splitedLine, int currentTotal) {
        switch (splitedLine[0]) {
            case APPLY:
                return (Integer.valueOf(splitedLine[1]));

            case ADD:
                return (currentTotal + Integer.valueOf(splitedLine[1]));

            case MULTIPLY:
                return (currentTotal * Integer.valueOf(splitedLine[1]));

            case DEVIDE:
                return (currentTotal / Integer.valueOf(splitedLine[1]));

            case SUBSTRACT:
                return (currentTotal - Integer.valueOf(splitedLine[1]));

            default:
                System.out.println("Invalid line: " + splitedLine[0]);
                return currentTotal;
        }

    }
}
