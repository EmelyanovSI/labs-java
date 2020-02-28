package by.gsu.kindergarten;

import by.gsu.abstr.Record;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

public class Worker extends Record {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦════════╦═════╦════════════╦═══════════╦═════════════════╦═══════════════╦═════════════╗\n" +
                    "║KEY║POSITION║GROUP║    NAME    ║    DOB    ║    EDUCATION    ║    ADDRESS    ║    PHONE    ║";
    private static final String MEDIUM =
            "╠═══╬════════╬═════╬════════════╬═══════════╬═════════════════╬═══════════════╬═════════════╣" +
                    "%n║%3d║%8d║%5d║%12s║%11s║%17s║%15s║%13s║";
    public static final String ENDING =
            "╚═══╩════════╩═════╩════════════╩═══════════╩═════════════════╩═══════════════╩═════════════╝";

    private int positionKey;
    private int groupKey;
    private String name;
    private LocalDate dateOfBirth;
    private String education;
    private String address;
    private int phone;

    public int getPositionKey() {
        return positionKey;
    }

    public void setPositionKey(int positionKey) {
        this.positionKey = positionKey;
    }

    public int getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(int groupKey) {
        this.groupKey = groupKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Worker() {
        this(new Position(), new Group(), UNKNOWN(), LocalDate.MIN, UNKNOWN(), UNKNOWN(), 0);
    }

    public Worker(
            Position position,
            Group group,
            String name,
            LocalDate dateOfBirth,
            String education,
            String address,
            int phone
    ) {
        setKey(counter++);
        positionKey = position.getKey();
        groupKey = group.getKey();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.education = education;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                getKey(),
                positionKey,
                groupKey,
                name,
                dateOfBirth,
                education,
                address,
                phone
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[]{s, s, s, LocalDate.now().toString(), s, s, s};
    }

}
