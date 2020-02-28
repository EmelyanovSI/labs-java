package by.gsu.kindergarten;

import java.util.Locale;

public class Position {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦═════════════╦════════════╗\n" +
            "║KEY║    TITLE    ║    TYPE    ║";
    private static final String MEDIUM =
            "╠═══╬═════════════╬════════════╣" +
            "%n║%3d║%13s║%12s║";
    public static final String ENDING =
            "╚═══╩═════════════╩════════════╝";
    private static final String UNKNOWN = "Unknown";

    private final int key;
    private String title;
    private String type;

    public int getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Position() {
        this(UNKNOWN, UNKNOWN);
    }

    public Position(String title, String type) {
        key = counter++;
        this.title = title;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                key,
                title,
                type
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[] {s, s};
    }

}
