package pl.gatomek;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterDemo {
    public static void main(String[] args) {
        System.out.println("PrintWriter Demo");

        try( PrintWriter pw = new PrintWriter( "test.txt")) {
            pw.println("Test");
            pw.println("Text");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}