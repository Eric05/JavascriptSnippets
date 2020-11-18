package at.checkExcel;

import at.checkExcel.FieldConditions.OperationFactory;
import at.checkExcel.FieldConditions.Operation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        var lines = Files.readAllLines(Path.of("C:\\Dev\\Employees.txt"));
        String[][] excel = new String[lines.size()][];

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i) != null) {
                excel[i] = new String[lines.get(i).split(",").length];
            }
            for (int j = 0; j < lines.get(i).split(",").length; j++) {
                excel[i][j] = lines.get(i).split(",")[j];
            }
        }
excel[2][0] = "";


        System.out.println(Arrays.deepToString(excel));

        //var cols = new CheckColumnForValidType();
CheckColumnForValidType.checkEmptyFields(excel,0);
CheckColumnForValidType.checkTypeByCol(excel,CheckColumnForValidType.colsToCheck);




    }

/*    public static boolean checkTypeByCol(String[][] excel, Map<Integer, String> cols) {
        for (int i = 0; i < excel.length; i++) {
            for (int j = 0; j < excel[i].length; j++) {
                Operation op = OperationFactory
                        .getOperation("null")
                        .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
                if (!op.testDataType(excel[i][j])) {
                    System.out.println("empty field on row " + i + " col " + j);

            }
*//*                if (cols.containsKey(j)) {
                    Operation targetOperation = OperationFactory
                            .getOperation(cols.get(j))
                            .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
                    if (!targetOperation.testDataType(excel[i][j])) {
                        System.out.println("error on line " + i + " col " + j);
                    } else {
                        System.out.println("ok");
                    }*//*

            }
        }
        return true;
    }*/

    static <T> void printVarArgArray(T... x) {
        if (x.length < 1) {
            System.out.println("##################");
        }
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + ",");
        }
    }

    private static <T> void Rotate(T[] arr, int shiftCount) {
        T[] backupArray = Arrays.copyOf(arr, arr.length);

        for (int index = 0; index < arr.length; index++) {
            backupArray[(index + arr.length + shiftCount % arr.length) % arr.length] = arr[index];
        }

        arr = backupArray;
    }
}


//var n = char.charCodeAt(0) - 'a'.charCodeAt();
// n = (n + offset) % 26;