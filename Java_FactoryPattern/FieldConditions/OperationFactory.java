package at.checkExcel.FieldConditions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperationFactory {
    static Map<String, Operation> operationMap = new HashMap<>();

    static {
        operationMap.put("num", new IsNumeric());
        operationMap.put("str", new IsString());
        operationMap.put("strNoDig", new IsStringWithoutDigits());
        operationMap.put("null", new IsNotEmptyOrNull());
    }

    public static Optional<Operation> getOperation(String operator) {
        return Optional.ofNullable(operationMap.get(operator));
    }
}

