package by.gsu.kindergarten;

import by.gsu.interfaces.Input;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Child extends Family implements Input {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦═════╦══════╦════════════╦═══════════╦═══════════╦═══════════╦═══════════╗\n" +
                    "║KEY║GROUP║FAMILY║    NAME    ║    SEX    ║    DOB    ║    DOE    ║    DOR    ║";
    private static final String MEDIUM =
            "╠═══╬═════╬══════╬════════════╬═══════════╬═══════════╬═══════════╬═══════════╣" +
                    "%n║%3d║%5d║%6d║%12s║%11s║%11s║%11s║%11s║";
    public static final String ENDING =
            "╚═══╩═════╩══════╩════════════╩═══════════╩═══════════╩═══════════╩═══════════╝";

    private int groupKey;
    private int familyKey;
    private String name;
    private String sex;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEnrollment;
    private LocalDate dateOfRelease;

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
        this(new Group(), new Family(), UNKNOWN(), UNKNOWN(), LocalDate.MIN, LocalDate.now(), LocalDate.MAX);
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
        setKey(counter++);
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
                getKey(),
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Child)) return false;
        Child child = (Child) o;
        return Objects.equals(getName(), child.getName()) &&
                Objects.equals(getSex(), child.getSex()) &&
                Objects.equals(getDateOfBirth(), child.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSex());
    }

    @Override
    public void input() {
        System.out.println("CHANGE ELEMENT:");
        final String[] strings = new Scanner(System.in).next().split(";");
        this.groupKey = Integer.parseInt(strings[0]);
        this.familyKey = Integer.parseInt(strings[1]);
        this.name = strings[2];
        this.sex = strings[3];
        this.dateOfBirth = LocalDate.parse(strings[4]);
        this.dateOfEnrollment = LocalDate.parse(strings[5]);
        this.dateOfRelease = LocalDate.parse(strings[6]);
        if (strings.length > 7)
            setAddress(strings[7]);
    }

    @Override
    public void print() {
        super.print();
        System.out.println(String.format(
                Locale.ENGLISH,
                OPENING + "\n" + MEDIUM + "\n" + ENDING,
                getKey(),
                groupKey,
                familyKey,
                name,
                sex,
                dateOfBirth,
                dateOfEnrollment,
                dateOfRelease
        ));
    }

}
