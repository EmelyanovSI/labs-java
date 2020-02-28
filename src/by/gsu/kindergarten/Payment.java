package by.gsu.kindergarten;

import java.time.LocalDate;
import java.util.Locale;

public class Payment {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦═════╦═════════════╦═══════════╗\n" +
            "║KEY║CHILD║    PRICE    ║    DOA    ║";
    private static final String MEDIUM =
            "╠═══╬═════╬═════════════╬═══════════╣" +
            "%n║%3d║%5d║%13s║%11s║";
    public static final String ENDING =
            "╚═══╩═════╩═════════════╩═══════════╝";
    private static final String UNKNOWN = "Unknown";

    private final int key;
    private int childKey;
    private String price;
    private LocalDate dateOfAccrual;

    public Payment() {
        this(new Child(), UNKNOWN, LocalDate.now());
    }

    public Payment(Child child, String price, LocalDate dateOfAccrual) {
        key = counter++;
        childKey = child.getKey();
        this.price = price;
        this.dateOfAccrual = dateOfAccrual;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                key,
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
