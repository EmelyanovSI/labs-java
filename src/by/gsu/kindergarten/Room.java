package by.gsu.kindergarten;

import java.util.Locale;

public class Room {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦═════════════╦════════════╦════════════╗\n" +
            "║KEY║    FLOOR    ║    SIZE    ║    TYPE    ║";
    private static final String MEDIUM =
            "╠═══╬═════════════╬════════════╬════════════╣" +
            "%n║%3d║%13s║%12s║%12s║";
    public static final String ENDING =
            "╚═══╩═════════════╩════════════╩════════════╝";
    private static final String UNKNOWN = "Unknown";

    private final int key;
    private int floor;
    private int size;
    private String type;

    public int getKey() {
        return key;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Room() {
        this(0, 0, UNKNOWN);
    }

    public Room(int floor, int size, String type) {
        key = counter++;
        this.floor = floor;
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                key,
                floor,
                size,
                type
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[] {s, s, s};
    }

}
