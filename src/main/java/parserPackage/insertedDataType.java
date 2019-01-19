package parserPackage;

public class insertedDataType {

    insertedDataType(String insertedKey, String insertedValue) {
        this.insertedKey = insertedKey;
        this.insertedValue = insertedValue;
    }

    private String insertedKey;
    private String insertedValue;

    public String getInsertedKey() {
        return insertedKey;
    }

    public String getInsertedValue() {
        return insertedValue;
    }
}
