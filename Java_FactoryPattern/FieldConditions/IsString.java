package at.checkExcel.FieldConditions;

public class IsString implements Operation {

    @Override
    public boolean testDataType(String data) {
        return data.getClass().getName().contains("String");
    }
}
