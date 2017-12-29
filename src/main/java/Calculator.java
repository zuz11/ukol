import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final String APPLY = "apply";
    private static final String ADD = "add";
    private static final String MULTIPLY = "multiply";
    private static final String DIVIDE = "divide";
    private static final String SUBTRACT = "subtract";
    public static final String SPACE = " ";

    public static void main(String[] args) {
        List<String> fileLines = new ArrayList<>();
        int total = 0;
        if (args.length <= 0) {
            System.out.println("File path not found, you have to put the file path as the first argument.");
            return;
        }
        try {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader buffReader = new BufferedReader(fileReader);
            String line = buffReader.readLine();

            while (line != null) {
                fileLines.add(line);
                line = buffReader.readLine();
            }

            buffReader.close();
            fileReader.close();


            if (!fileLines.isEmpty()) {
                int currentTotal = 0;
                currentTotal = calculateTotalFromLine(fileLines.get(fileLines.size() - 1).split(SPACE), total);
                for (int i = 0; i < fileLines.size() - 1; i++) {
                    currentTotal = calculateTotalFromLine(fileLines.get(i).split(SPACE), currentTotal);
                }
                total = currentTotal;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(total);
    }

    private static int calculateTotalFromLine(String[] splitedLine, int currentTotal) throws IOException {
        switch (splitedLine[0]) {
            case APPLY:
                return (Integer.valueOf(splitedLine[1]));

            case ADD:
                return (currentTotal + Integer.valueOf(splitedLine[1]));

            case MULTIPLY:
                return (currentTotal * Integer.valueOf(splitedLine[1]));

            case DIVIDE:
                return (currentTotal / Integer.valueOf(splitedLine[1]));

            case SUBTRACT:
                return (currentTotal - Integer.valueOf(splitedLine[1]));

            default:
                System.out.println("Invalid line string: " + splitedLine[0]);
                throw new IOException();
        }

    }
}
