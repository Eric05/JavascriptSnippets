package at.checkExcel;

import at.checkExcel.FieldConditions.Operation;
import at.checkExcel.FieldConditions.OperationFactory;

import java.util.HashMap;
import java.util.Map;

/***
 * Map with Column number and exprcted Type
 */
public class CheckColumnForValidType {

    public static Map<Integer, String> colsToCheck = new HashMap<>() {{
        {
            put(0, "str");
            put(1, "num");
        }
    }};

    public static void checkEmptyFields(String[][] excel, int firstRow, int... lastRow) {
        Operation op = OperationFactory
                .getOperation("null")
                .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
        int last = (lastRow.length < 1) ? excel.length : lastRow[0];

        for (int i = firstRow; i < last; i++) {
            for (int j = 0; j < excel[i].length; j++) {
                if (!op.testDataType(excel[i][j])) {
                    ErrorAction.printError(i, j, "Empty field  on: ");
                }
            }
        }
    }

    public static void checkTypeByCol(String[][] excel, Map<Integer, String> cols) {
        for (int i = 0; i < excel.length; i++) {
            for (int j = 0; j < excel[i].length; j++) {

                if (cols.containsKey(j)) {
                    Operation targetOperation = OperationFactory
                            .getOperation(cols.get(j))
                            .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
                    if (!targetOperation.testDataType(excel[i][j])) {
                        ErrorAction.printError(i, j, "Wrong datatype on: ");
                    }
                }
            }
        }
    }
}
