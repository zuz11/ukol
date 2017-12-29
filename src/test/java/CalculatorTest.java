import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


    @Test
    public void testCalculatorMain1() throws FileNotFoundException {
        URL url=getClass().getResource("test_file1");

        String[] args= new String[1];
        args[0]=url.getPath();

        Calculator.main(args);
        assertEquals("1", outContent.toString().replaceAll("(\\r|\\n)", ""));
    }

    @Test
    public void testCalculatorMain2() throws FileNotFoundException {
        URL url=getClass().getResource("test_file2");

        String[] args= new String[1];
        args[0]=url.getPath();

        Calculator.main(args);
        assertEquals("18", outContent.toString().replaceAll("(\\r|\\n)", ""));
    }

    @Test
    public void testCalculatorMain3() throws FileNotFoundException {
        URL url=getClass().getResource("test_file3");

        String[] args= new String[1];
        args[0]=url.getPath();

        Calculator.main(args);
        assertEquals("45", outContent.toString().replaceAll("(\\r|\\n)", ""));
    }
}

