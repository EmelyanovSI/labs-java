package by.gsu.kindergarten;

import java.util.Locale;

public class Group {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦════╦═════════════╦════════════════╗\n" +
            "║KEY║ROOM║    TITLE    ║    CATEGORY    ║";
    private static final String MEDIUM =
            "╠═══╬════╬═════════════╬════════════════╣" +
            "%n║%3d║%4d║%13s║%16s║";
    public static final String ENDING =
            "╚═══╩════╩═════════════╩════════════════╝";
    private static final String UNKNOWN = "Unknown";

    private final int key;
    private int roomKey;
    private String title;
    private String category;

    public int getKey() {
        return key;
    }

    public int getRoomKey() {
        return roomKey;
    }

    public void setRoomKey(int roomKey) {
        this.roomKey = roomKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Group() {
        this(new Room(), UNKNOWN, UNKNOWN);
    }

    public Group(Room room, String title, String category) {
        key = counter++;
        roomKey = room.getKey();
        this.title = title;
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                key,
                roomKey,
                title,
                category
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[] {s, s, s};
    }

}
