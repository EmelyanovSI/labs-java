package by.gsu.kindergarten;

import java.util.Locale;

public class Circle {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦══════╦════╦═════════════╦════════════╦═════════════╗\n" +
            "║KEY║WORKER║ROOM║    TITLE    ║    TIME    ║    PRICE    ║";
    private static final String MEDIUM =
            "╠═══╬══════╬════╬═════════════╬════════════╬═════════════╣" +
            "%n║%3d║%6d║%4d║%13s║%12s║%13s║";
    public static final String ENDING =
            "╚═══╩══════╩════╩═════════════╩════════════╩═════════════╝";
    private static final String UNKNOWN = "Unknown";

    private final int key;
    private int workerKey;
    private int roomKey;
    private String title;
    private String time;
    private String price;

    public int getKey() {
        return key;
    }

    public int getWorkerKey() {
        return workerKey;
    }

    public void setWorkerKey(int workerKey) {
        this.workerKey = workerKey;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Circle() {
        this(new Worker(), new Room(), UNKNOWN, UNKNOWN, UNKNOWN);
    }

    public Circle(Worker employee, Room room, String title, String time, String price) {
        key = counter++;
        workerKey = employee.getKey();
        roomKey = room.getKey();
        this.title = title;
        this.time = time;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                key,
                workerKey,
                roomKey,
                title,
                time,
                price
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[] {s, s, s, s, s};
    }

}
