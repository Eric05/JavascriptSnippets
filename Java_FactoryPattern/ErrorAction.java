package at.checkExcel;

import java.io.FileWriter;
import java.io.IOException;

public class ErrorAction {

    public static void printError(int row, int col, String msg) {
        System.out.println(msg + row + " / " + col);
    }

    public static void writeErrorLog(int row, int col, String msg, String path) {
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.append(msg);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

