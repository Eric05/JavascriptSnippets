package at.checkExcel.FieldConditions;

public class IsNotEmptyOrNull implements Operation {

    @Override
    public boolean testDataType(String data) {
        if (data.equals("") || data == null) {
            return false;
        }
        return true;
    }
}
