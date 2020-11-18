package at.checkExcel.FieldConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsStringWithoutDigits implements Operation {

    @Override
    public boolean testDataType(String data) {
        Pattern pat = Pattern.compile("[0-9]");
        Matcher matcher = pat.matcher((CharSequence) data);

        return !matcher.find();
    }
}
