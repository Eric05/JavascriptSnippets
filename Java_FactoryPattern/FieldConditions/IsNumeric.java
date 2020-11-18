package at.checkExcel.FieldConditions;

import java.util.regex.Pattern;

public class IsNumeric implements Operation {

    @Override
    public boolean testDataType(String data) {
        try {
            double d = Double.parseDouble(data);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
