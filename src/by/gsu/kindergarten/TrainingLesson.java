package by.gsu.kindergarten;

import by.gsu.abstr.Record;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

public class TrainingLesson extends Record {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦═════╦══════╦════╦═════════════╦═══════════╗\n" +
                    "║KEY║GROUP║WORKER║ROOM║    TITLE    ║    DOL    ║";
    private static final String MEDIUM =
            "╠═══╬═════╬══════╬════╬═════════════╬═══════════╣" +
                    "%n║%3d║%5d║%6d║%4d║%13s║%11s║";
    public static final String ENDING =
            "╚═══╩═════╩══════╩════╩═════════════╩═══════════╝";

    private int groupKey;
    private int workerKey;
    private int roomKey;
    private String title;
    private LocalDate dateOfLesson;

    public int getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(int groupKey) {
        this.groupKey = groupKey;
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

    public LocalDate getDateOfLesson() {
        return dateOfLesson;
    }

    public void setDateOfLesson(LocalDate dateOfLesson) {
        this.dateOfLesson = dateOfLesson;
    }

    public TrainingLesson() {
        this(new Group(), new Worker(), new Room(), UNKNOWN(), LocalDate.now());
    }

    public TrainingLesson(Group group, Worker worker, Room room, String title, LocalDate dateOfLesson) {
        setKey(counter++);
        groupKey = group.getKey();
        workerKey = worker.getKey();
        roomKey = room.getKey();
        this.title = title;
        this.dateOfLesson = dateOfLesson;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                getKey(),
                groupKey,
                workerKey,
                roomKey,
                title,
                dateOfLesson
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[] {s, s, s, s, LocalDate.now().toString()};
    }

}
