package by.gsu.kindergarten;

import java.time.LocalDate;
import java.util.Locale;

public class Toy {

    private static int counter = 1;
    public static final String OPENING =
            "╔═══╦═════╦═════════════╦════════════════╦═════════════╦═══════════╦═══════════╗\n" +
                    "║KEY║GROUP║    TITLE    ║    QUANTITY    ║    PRICE    ║    DOD    ║    DOW    ║";
    private static final String MEDIUM =
            "╠═══╬═════╬═════════════╬════════════════╬═════════════╬═══════════╬═══════════╣" +
                    "%n║%3d║%5d║%13s║%16s║%13s║%11s║%11s║";
    public static final String ENDING =
            "╚═══╩═════╩═════════════╩════════════════╩═════════════╩═══════════╩═══════════╝";
    private static final String UNKNOWN = "Unknown";

    private final int key;
    private int groupKey;
    private String title;
    private int quantity;
    private String price;
    private LocalDate dateOfDelivery;
    private LocalDate dateOfWriteOff;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LocalDate getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(LocalDate dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public LocalDate getDateOfWriteOff() {
        return dateOfWriteOff;
    }

    public void setDateOfWriteOff(LocalDate dateOfWriteOff) {
        this.dateOfWriteOff = dateOfWriteOff;
    }

    public Toy() {
        this(new Group(), UNKNOWN, 0, UNKNOWN, LocalDate.now(), LocalDate.MAX);
    }

    public Toy(
            Group group,
            String title,
            int quantity,
            String price,
            LocalDate dateOfDelivery,
            LocalDate dateOfWriteOff
    ) {
        key = counter++;
        groupKey = group.getKey();
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.dateOfDelivery = dateOfDelivery;
        this.dateOfWriteOff = dateOfWriteOff;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                MEDIUM,
                key,
                groupKey,
                title,
                quantity,
                price,
                dateOfDelivery,
                dateOfWriteOff
        );
    }

    public static String[] initialize(int i) {
        final String s = String.valueOf(i);
        return new String[]{s, s, s, s, LocalDate.now().toString(), LocalDate.now().toString()};
    }

}
