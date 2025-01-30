package pl.gatomek;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class PrintWriterDemoTest {

    private final static String LINE_0 = "Test";
    private final static String LINE_1 = "Text";
    private final static String LINE_SEP = System.lineSeparator();
    private final static String FOLDER = "tests";

    @BeforeAll
    static void setUp() {
        File folder = new File(FOLDER);
        folder.mkdirs();
    }

    @Test
    void writeFileTest1() throws IOException {
        String filePath = FOLDER + "/test1.txt";
        try (PrintWriter pw = new PrintWriter(filePath)) {
            pw.println(LINE_0);
            pw.println(LINE_1);

            assertTrue(!pw.checkError());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        String actual = new String(bytes);

        String expected = LINE_0 + LINE_SEP + LINE_1 + LINE_SEP;

        assertEquals(expected, actual);
    }

    @Test
    void writeFileTest2() throws IOException {
        String filePath = FOLDER + "/test2.txt";
        try (PrintWriter pw = new PrintWriter(filePath)) {
            pw.println(LINE_0);
            pw.println(LINE_1);

            assertTrue(!pw.checkError());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            assertEquals(LINE_0, reader.readLine());
            assertEquals(LINE_1, reader.readLine());
        }
    }
}
