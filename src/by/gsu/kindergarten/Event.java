package by.gsu.kindergarten;

import java.time.LocalDate;
import java.util.Locale;

public class Event {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦═════╦═════════════╦═══════════╗\n" +
            "║KEY║GROUP║    TITLE    ║    DOE    ║";
    private static final String MEDIUM =
            "╠═══╬═════╬═════════════╬═══════════╣" +
            "%n║%3d║%5d║%13s║%11s║";
    public static final String ENDING =
            "╚═══╩═════╩═════════════╩═══════════╝";
    private static final String UNKNOWN = "Unknown";

    private final int key;
    private int groupKey;
    private String title;
    private LocalDate dateOfEvent;

    public int getKey() {
        return key;
    }

    public int getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(int groupKey) {
        this.groupKey = groupKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(LocalDate dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public Event() {
        this(new Group(), UNKNOWN, LocalDate.now());
    }

    public Event(Group group, String title, LocalDate dateOfEvent) {
        key = counter++;
        groupKey = group.getKey();
        this.title = title;
        this.dateOfEvent = dateOfEvent;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                key,
                groupKey,
                title,
                dateOfEvent
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[] {s, s, LocalDate.now().toString()};
    }

}