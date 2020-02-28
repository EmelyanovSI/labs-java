package by.gsu.abstr;

public abstract class Record {
    private int key;
    private static final String UNKNOWN = "Unknown";

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public static String UNKNOWN() {
        return UNKNOWN;
    }
}
