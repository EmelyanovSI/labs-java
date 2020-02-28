package by.gsu.kindergarten;

import by.gsu.abstr.Record;
import by.gsu.interfaces.Print;

import java.util.Locale;
import java.util.Objects;

public class Family extends Record implements Print {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦═══════════════╦══════════════╦══════════════╦══════════════════╦═════════════════════╦══════════════╦══════════════════╦═════════════════════╗\n" +
                    "║KEY║    ADDRESS    ║    NUMBER    ║    MOTHER    ║    MOTHER_JOB    ║    MOTHER_NUMBER    ║    FATHER    ║    FATHER_JOB    ║    FATHER_NUMBER    ║";
    private static final String MEDIUM =
            "╠═══╬═══════════════╬══════════════╬══════════════╬══════════════════╬═════════════════════╬══════════════╬══════════════════╬═════════════════════╣" +
                    "%n║%3d║%15s║%14d║%14s║%18s║%21d║%14s║%18s║%21d║";
    public static final String ENDING =
            "╚═══╩═══════════════╩══════════════╩══════════════╩══════════════════╩═════════════════════╩══════════════╩══════════════════╩═════════════════════╝";

    private String address;
    private int homeNumber;
    private String motherName;
    private String motherJob;
    private int motherNumber;
    private String fatherName;
    private String fatherJob;
    private int fatherNumber;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherJob() {
        return motherJob;
    }

    public void setMotherJob(String motherJob) {
        this.motherJob = motherJob;
    }

    public int getMotherNumber() {
        return motherNumber;
    }

    public void setMotherNumber(int motherNumber) {
        this.motherNumber = motherNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherJob() {
        return fatherJob;
    }

    public void setFatherJob(String fatherJob) {
        this.fatherJob = fatherJob;
    }

    public int getFatherNumber() {
        return fatherNumber;
    }

    public void setFatherNumber(int fatherNumber) {
        this.fatherNumber = fatherNumber;
    }

    public Family() {
        this(UNKNOWN(), 0, UNKNOWN(), UNKNOWN(), 0, UNKNOWN(), UNKNOWN(), 0);
    }

    public Family(
            String address,
            int homeNumber,
            String motherName,
            String motherJob,
            int motherNumber,
            String fatherName,
            String fatherJob,
            int fatherNumber
    ) {
        setKey(counter++);
        this.address = address;
        this.homeNumber = homeNumber;
        this.motherName = motherName;
        this.motherJob = motherJob;
        this.motherNumber = motherNumber;
        this.fatherName = fatherName;
        this.fatherJob = fatherJob;
        this.fatherNumber = fatherNumber;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                getKey(),
                address,
                homeNumber,
                motherName,
                motherJob,
                motherNumber,
                fatherName,
                fatherJob,
                fatherNumber
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[]{s, s, s, s, s, s, s, s};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return Objects.equals(getMotherName(), family.getMotherName()) &&
                Objects.equals(getFatherName(), family.getFatherName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMotherName(), getFatherName());
    }

    @Override
    public void print() {
        System.out.println("ELEMENT:");
        System.out.println(String.format(
                Locale.ENGLISH,
                OPENING + "\n" + MEDIUM + "\n" + ENDING,
                getKey(),
                address,
                homeNumber,
                motherName,
                motherJob,
                motherNumber,
                fatherName,
                fatherJob,
                fatherNumber
        ));
    }

}
