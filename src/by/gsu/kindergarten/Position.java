package by.gsu.kindergarten;

import by.gsu.abstr.Record;

import java.util.Locale;
import java.util.Objects;

public class Position extends Record {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦═════════════╦════════════╗\n" +
                    "║KEY║    TITLE    ║    TYPE    ║";
    private static final String MEDIUM =
            "╠═══╬═════════════╬════════════╣" +
                    "%n║%3d║%13s║%12s║";
    public static final String ENDING =
            "╚═══╩═════════════╩════════════╝";

    private String title;
    private String type;

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
        this(UNKNOWN(), UNKNOWN());
    }

    public Position(String title, String type) {
        setKey(counter++);
        this.title = title;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                getKey(),
                title,
                type
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[]{s, s};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return Objects.equals(getTitle(), position.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }

}
