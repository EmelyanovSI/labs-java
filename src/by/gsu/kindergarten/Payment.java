package by.gsu.kindergarten;

import by.gsu.abstr.Record;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

public class Payment extends Record {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦═════╦═════════════╦═══════════╗\n" +
                    "║KEY║CHILD║    PRICE    ║    DOA    ║";
    private static final String MEDIUM =
            "╠═══╬═════╬═════════════╬═══════════╣" +
                    "%n║%3d║%5d║%13s║%11s║";
    public static final String ENDING =
            "╚═══╩═════╩═════════════╩═══════════╝";

    private int childKey;
    private String price;
    private LocalDate dateOfAccrual;

    public int getChildKey() {
        return childKey;
    }

    public void setChildKey(int childKey) {
        this.childKey = childKey;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LocalDate getDateOfAccrual() {
        return dateOfAccrual;
    }

    public void setDateOfAccrual(LocalDate dateOfAccrual) {
        this.dateOfAccrual = dateOfAccrual;
    }

    public Payment() {
        this(new Child(), UNKNOWN(), LocalDate.now());
    }

    public Payment(Child child, String price, LocalDate dateOfAccrual) {
        setKey(counter++);
        childKey = child.getKey();
        this.price = price;
        this.dateOfAccrual = dateOfAccrual;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                getKey(),
                childKey,
                price,
                dateOfAccrual
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[] {s, s, LocalDate.now().toString()};
    }

}
