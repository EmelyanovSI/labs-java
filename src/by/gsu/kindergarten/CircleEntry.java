package by.gsu.kindergarten;

import by.gsu.abstr.Record;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

public class CircleEntry extends Record {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦═════╦══════╦═════════════╦═════════════╗\n" +
                    "║KEY║CHILD║CIRCLE║    DORec    ║    DORel    ║";
    private static final String MEDIUM =
            "╠═══╬═════╬══════╬═════════════╬═════════════╣" +
                    "%n║%3d║%5d║%6d║%13s║%13s║";
    public static final String ENDING =
            "╚═══╩═════╩══════╩═════════════╩═════════════╝";

    private int childKey;
    private int circleKey;
    private LocalDate dateOfRecord;
    private LocalDate dateOfRelease;

    public int getChildKey() {
        return childKey;
    }

    public void setChildKey(int childKey) {
        this.childKey = childKey;
    }

    public int getCircleKey() {
        return circleKey;
    }

    public void setCircleKey(int circleKey) {
        this.circleKey = circleKey;
    }

    public LocalDate getDateOfRecord() {
        return dateOfRecord;
    }

    public void setDateOfRecord(LocalDate dateOfRecord) {
        this.dateOfRecord = dateOfRecord;
    }

    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public CircleEntry() {
        this(new Child(), new Circle(), LocalDate.now(), LocalDate.MAX);
    }

    public CircleEntry(Child child, Circle circle, LocalDate dateOfRecord, LocalDate dateOfRelease) {
        setKey(counter++);
        childKey = child.getKey();
        circleKey = circle.getKey();
        this.dateOfRecord = dateOfRecord;
        this.dateOfRelease = dateOfRelease;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                getKey(),
                childKey,
                circleKey,
                dateOfRecord,
                dateOfRelease
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[]{s, s, LocalDate.now().toString(), LocalDate.now().toString()};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CircleEntry)) return false;
        CircleEntry that = (CircleEntry) o;
        return getChildKey() == that.getChildKey() &&
                getCircleKey() == that.getCircleKey();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChildKey(), getCircleKey());
    }

}
