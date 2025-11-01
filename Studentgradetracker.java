import java.util.*;

class Studentgradetracker {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Integer> marks = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Class Average");
            System.out.println("3. Show Highest and Lowest Marks");
            System.out.println("4. Show All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> showAverage();
                case 3 -> showHighLow();
                case 4 -> showAll();
                case 5 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.next();
        System.out.print("Enter marks: ");
        int mark = sc.nextInt();
        names.add(name);
        marks.add(mark);
        System.out.println("✅ Student added successfully!");
    }

    static void showAverage() {
        if (marks.isEmpty()) {
            System.out.println("No students yet!");
            return;
        }
        int total = 0;
        for (int m : marks) total += m;
        double avg = (double) total / marks.size();
        System.out.println("Class Average: " + avg);
    }

    static void showHighLow() {
        if (marks.isEmpty()) {
            System.out.println("No students yet!");
            return;
        }
        int min = marks.get(0), max = marks.get(0);
        int minIndex = 0, maxIndex = 0;

        for (int i = 1; i < marks.size(); i++) {
            if (marks.get(i) < min) {
                min = marks.get(i);
                minIndex = i;
            }
            if (marks.get(i) > max) {
                max = marks.get(i);
                maxIndex = i;
            }
        }

        System.out.println("Highest Marks: " + names.get(maxIndex) + " (" + max + ")");
        System.out.println("Lowest Marks: " + names.get(minIndex) + " (" + min + ")");
    }

    static void showAll() {
        if (names.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + marks.get(i));
        }
    }
}
