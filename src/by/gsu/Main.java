package by.gsu;

import by.gsu.kindergarten.*;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static int CAPACITY = 10;
    private static final String[] TYPES = {
            "Position", "Room", "Family",
            "Group", "Child", "Worker",
            "Circle", "CircleEntry", "Event",
            "Payment", "Toy", "TrainingLesson"
    };
    private static final Child[] CHILDREN = new Child[CAPACITY];
    private static final Circle[] CIRCLES = new Circle[CAPACITY];
    private static final CircleEntry[] CIRCLE_ENTRIES = new CircleEntry[CAPACITY];
    private static final Event[] EVENTS = new Event[CAPACITY];
    private static final Family[] FAMILIES = new Family[CAPACITY];
    private static final Group[] GROUPS = new Group[CAPACITY];
    private static final Payment[] PAYMENTS = new Payment[CAPACITY];
    private static final Position[] POSITIONS = new Position[CAPACITY];
    private static final Room[] ROOMS = new Room[CAPACITY];
    private static final Toy[] TOYS = new Toy[CAPACITY];
    private static final TrainingLesson[] TRAINING_LESSONS = new TrainingLesson[CAPACITY];
    private static final Worker[] WORKERS = new Worker[CAPACITY];

    private Main() {
        super();
    }

    private static void initializeElement(int type, String[] strings, int index) {
        switch (type) {
            case 4:
                CHILDREN[index] = new Child(
                        GROUPS[Integer.parseInt(strings[0]) - 1],
                        FAMILIES[Integer.parseInt(strings[1]) - 1],
                        strings[2],
                        strings[3],
                        LocalDate.parse(strings[4]),
                        LocalDate.parse(strings[5]),
                        LocalDate.parse(strings[6])
                );
                break;
            case 6:
                CIRCLES[index] = new Circle(
                        WORKERS[Integer.parseInt(strings[0]) - 1],
                        ROOMS[Integer.parseInt(strings[1]) - 1],
                        strings[2],
                        strings[3],
                        strings[4]
                );
                break;
            case 7:
                CIRCLE_ENTRIES[index] = new CircleEntry(
                        CHILDREN[Integer.parseInt(strings[0]) - 1],
                        CIRCLES[Integer.parseInt(strings[1]) - 1],
                        LocalDate.parse(strings[2]),
                        LocalDate.parse(strings[3])
                );
                break;
            case 8:
                EVENTS[index] = new Event(
                        GROUPS[Integer.parseInt(strings[0]) - 1],
                        strings[1],
                        LocalDate.parse(strings[2])
                );
                break;
            case 2:
                FAMILIES[index] = new Family(
                        strings[0],
                        Integer.parseInt(strings[1]),
                        strings[2],
                        strings[3],
                        Integer.parseInt(strings[4]),
                        strings[5],
                        strings[6],
                        Integer.parseInt(strings[7])
                );
                break;
            case 3:
                GROUPS[index] = new Group(
                        ROOMS[Integer.parseInt(strings[0]) - 1],
                        strings[1],
                        strings[2]
                );
                break;
            case 9:
                PAYMENTS[index] = new Payment(
                        CHILDREN[Integer.parseInt(strings[0]) - 1],
                        strings[1],
                        LocalDate.parse(strings[2])
                );
                break;
            case 0:
                POSITIONS[index] = new Position(
                        strings[0],
                        strings[1]
                );
                break;
            case 1:
                ROOMS[index] = new Room(
                        Integer.parseInt(strings[0]),
                        Integer.parseInt(strings[1]),
                        strings[2]
                );
                break;
            case 10:
                TOYS[index] = new Toy(
                        GROUPS[Integer.parseInt(strings[0]) - 1],
                        strings[1],
                        Integer.parseInt(strings[2]),
                        strings[3],
                        LocalDate.parse(strings[4]),
                        LocalDate.parse(strings[5])
                );
                break;
            case 11:
                TRAINING_LESSONS[index] = new TrainingLesson(
                        GROUPS[Integer.parseInt(strings[0]) - 1],
                        WORKERS[Integer.parseInt(strings[1]) - 1],
                        ROOMS[Integer.parseInt(strings[2]) - 1],
                        strings[3],
                        LocalDate.parse(strings[4])
                );
                break;
            case 5:
                WORKERS[index] = new Worker(
                        POSITIONS[Integer.parseInt(strings[0]) - 1],
                        GROUPS[Integer.parseInt(strings[1]) - 1],
                        strings[2],
                        LocalDate.parse(strings[3]),
                        strings[4],
                        strings[5],
                        Integer.parseInt(strings[6])
                );
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    private static void mathInput(int type) {
        for (int i = 0; i < CAPACITY; i++) {
            switch (type) {
                case 4:
                    initializeElement(type, Child.initialize((int) (Math.random() * 5) + 1), i);
                    break;
                case 6:
                    initializeElement(type, Circle.initialize((int) (Math.random() * 5) + 1), i);
                    break;
                case 7:
                    initializeElement(type, CircleEntry.initialize((int) (Math.random() * 5) + 1), i);
                    break;
                case 8:
                    initializeElement(type, Event.initialize((int) (Math.random() * 5) + 1), i);
                    break;
                case 2:
                    initializeElement(type, Family.initialize((int) (Math.random() * 5) + 1), i);
                    break;
                case 3:
                    initializeElement(type, Group.initialize((int) (Math.random() * 5) + 1), i);
                    break;
                case 9:
                    initializeElement(type, Payment.initialize((int) (Math.random() * 5) + 1), i);
                    break;
                case 0:
                    initializeElement(type, Position.initialize((int) (Math.random() * 5) + 1), i);
                    break;
                case 1:
                    initializeElement(type, Room.initialize((int) (Math.random() * 5) + 1), i);
                    break;
                case 10:
                    initializeElement(type, Toy.initialize((int) (Math.random() * 5) + 1), i);
                    break;
                case 11:
                    initializeElement(type, TrainingLesson.initialize((int) (Math.random() * 5) + 1), i);
                    break;
                case 5:
                    initializeElement(type, Worker.initialize((int) (Math.random() * 5) + 1), i);
                    break;
                default:
                    return;
            }
        }
    }

    private static void consoleInput(int type, Scanner scanner) {
        for (int i = 0; i < CAPACITY; i++) {
            System.out.println(TYPES[type].toUpperCase());
            final String newString = scanner.next();
            final String[] strings = newString.split(";");
            initializeElement(type, strings, i);
        }
    }

    private static void fileInput(int type, String fileName) {
        try (BufferedReader file = new BufferedReader(new FileReader(new File(fileName)))) {
            int i = 0;
            String newString = file.readLine();
            while (newString != null && i < CAPACITY) {
                final String[] strings = newString.split(";");
                initializeElement(type, strings, i++);
                newString = file.readLine();
            }
        } catch (IOException e) {
            System.out.println("FILE INPUT ERROR");
        }
    }

    private static void xmlInput(int type, String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        String temp;
        StringBuilder string = new StringBuilder();
        Pattern pattern = Pattern.compile(">(.*)<");
        Matcher matcher;
        scanner.nextLine();
        scanner.nextLine();
        for (int i = 0; i < CAPACITY; i++) {
            try {
                scanner.nextLine();
            } catch (Exception e) {
                final String[] strings = string.toString().split(";");
                initializeElement(type, strings, i);
                return;
            }
            temp = scanner.nextLine();
            matcher = pattern.matcher(temp);
            while (matcher.find()) {
                string.append(matcher.group(1)).append(";");
                temp = scanner.nextLine();
                matcher = pattern.matcher(temp);
            }
            scanner.nextLine();
            final String[] strings = string.toString().split(";");
            initializeElement(type, strings, i);
        }
    }

    private static void print(int type) {
        System.out.println(TYPES[type].toUpperCase());
        final Object[] objects;
        final String ending;
        switch (type) {
            case 4:
                System.out.println(Child.OPENING);
                ending = Child.ENDING;
                objects = CHILDREN;
                break;
            case 6:
                System.out.println(Circle.OPENING);
                ending = Circle.ENDING;
                objects = CIRCLES;
                break;
            case 7:
                System.out.println(CircleEntry.OPENING);
                ending = CircleEntry.ENDING;
                objects = CIRCLE_ENTRIES;
                break;
            case 8:
                System.out.println(Event.OPENING);
                ending = Event.ENDING;
                objects = EVENTS;
                break;
            case 2:
                System.out.println(Family.OPENING);
                ending = Family.ENDING;
                objects = FAMILIES;
                break;
            case 3:
                System.out.println(Group.OPENING);
                ending = Group.ENDING;
                objects = GROUPS;
                break;
            case 9:
                System.out.println(Payment.OPENING);
                ending = Payment.ENDING;
                objects = PAYMENTS;
                break;
            case 0:
                System.out.println(Position.OPENING);
                ending = Position.ENDING;
                objects = POSITIONS;
                break;
            case 1:
                System.out.println(Room.OPENING);
                ending = Room.ENDING;
                objects = ROOMS;
                break;
            case 10:
                System.out.println(Toy.OPENING);
                ending = Toy.ENDING;
                objects = TOYS;
                break;
            case 11:
                System.out.println(TrainingLesson.OPENING);
                ending = TrainingLesson.ENDING;
                objects = TRAINING_LESSONS;
                break;
            case 5:
                System.out.println(Worker.OPENING);
                ending = Worker.ENDING;
                objects = WORKERS;
                break;
            default:
                return;
        }
        for (Object object : objects) {
            if (object != null) {
                System.out.println(object);
            } else {
                break;
            }
        }
        System.out.println(ending);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\nLOAD & PRINT:" +
                "\n1. MATH" +
                "\n2. TXT FILE" +
                "\n3. XML FILE" +
                "\n4. CONSOLE");
        int length = TYPES.length;
        final String[] strings = new Scanner(System.in).next().split(";");
        switch (Integer.parseInt(strings[0])) {
            case 1:
                CAPACITY = 10;
                System.out.println("\n\nMATH INPUT\n\n");
                for (int i = 0; i < length; i++) {
                    mathInput(i);
                }
                break;
            case 2:
                CAPACITY = 10;
                System.out.println("\n\nFILE INPUT\n\n");
                for (int i = 0; i < length; i++) {
                    fileInput(i, "src/by/gsu/data/txt/" + TYPES[i] + ".txt");
                }
                break;
            case 3:
                CAPACITY = 10;
                System.out.println("\n\nXML INPUT\n\n");
                for (int i = 0; i < length; i++) {
                    xmlInput(i, "src/by/gsu/data/xml/" + TYPES[i] + ".xml");
                }
                break;
            case 4:
                CAPACITY = 1;
                System.out.println("CONSOLE INPUT\n\n");
                final Scanner scanner = new Scanner(System.in);
                for (int i = 0; i < length; i++) {
                    consoleInput(i, scanner);
                    System.out.println();
                }
                scanner.close();
                System.out.println();
                break;
            default:
                System.out.println("NO OUTPUT");
        }
        for (int i = 0; i < length; i++) {
            print(i);
            System.out.println();
        }

        CHILDREN[0].input();
        CHILDREN[0].print();
        FAMILIES[0].print();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
