package by.gsu.kindergarten;

import java.time.LocalDate;
import java.util.Locale;

public class Child {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦═════╦══════╦════════════╦═══════════╦═══════════╦═══════════╦═══════════╗\n" +
                    "║KEY║GROUP║FAMILY║    NAME    ║    SEX    ║    DOB    ║    DOE    ║    DOR    ║";
    private static final String MEDIUM =
            "╠═══╬═════╬══════╬════════════╬═══════════╬═══════════╬═══════════╬═══════════╣" +
                    "%n║%3d║%5d║%6d║%12s║%11s║%11s║%11s║%11s║";
    public static final String ENDING =
            "╚═══╩═════╩══════╩════════════╩═══════════╩═══════════╩═══════════╩═══════════╝";
    private static final String UNKNOWN = "Unknown";

    private final int key;
    private int groupKey;
    private int familyKey;
    private String name;
    private String sex;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEnrollment;
    private LocalDate dateOfRelease;

    public int getKey() {
        return key;
    }

    public int getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(int groupKey) {
        this.groupKey = groupKey;
    }

    public int getFamilyKey() {
        return familyKey;
    }

    public void setFamilyKey(int familyKey) {
        this.familyKey = familyKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public Child() {
        this(new Group(), new Family(), UNKNOWN, UNKNOWN, LocalDate.MIN, LocalDate.now(), LocalDate.MAX);
    }

    public Child(
            Group group,
            Family family,
            String name,
            String sex,
            LocalDate dateOfBirth,
            LocalDate dateOfEnrollment,
            LocalDate dateOfRelease
    ) {
        key = counter++;
        this.groupKey = group.getKey();
        this.familyKey = family.getKey();
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEnrollment = dateOfEnrollment;
        this.dateOfRelease = dateOfRelease;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                key,
                groupKey,
                familyKey,
                name,
                sex,
                dateOfBirth,
                dateOfEnrollment,
                dateOfRelease
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[]{
                s, s, s, s, LocalDate.now().toString(), LocalDate.now().toString(), LocalDate.now().toString()
        };
    }

}
