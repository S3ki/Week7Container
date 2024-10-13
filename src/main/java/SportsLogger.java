import java.util.ArrayList;
import java.util.Scanner;

public class SportsLogger {
    static class Activity {
        String name;
        int duration;
        Activity(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }
    }

    private static final ArrayList<Activity> activities = new ArrayList<>();

    private static void logActivity(Scanner scanner) {
        System.out.print("Enter the name of the activity: ");
        String name = scanner.nextLine();
        System.out.print("Enter the duration in minutes: ");
        int duration = scanner.nextInt();
        scanner.nextLine();


        activities.add(new Activity(name, duration));
        System.out.println("Activity logged successfully!");
    }

    private static void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged yet.");
        } else {
            System.out.println("\nLogged Activities:");
            for (int i = 0; i < activities.size(); i++) {
                Activity activity = activities.get(i);
                System.out.println((i + 1) + ". " + activity.name + " - " + activity.duration + " minutes");
            }
        }
    }

    private static void calculateTotalTime() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged yet.");
        } else {
            int totalMinutes = 0;
            for (Activity activity : activities) {
                totalMinutes += activity.duration;
            }

            int hours = totalMinutes / 60;
            int minutes = totalMinutes % 60;

            System.out.println("\nTotal time spent on sports: " + hours + " hours and " + minutes + " minutes.");
        }
    }

    // Main method at the bottom
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSports Activity Logger");
            System.out.println("1. Log a new activity");
            System.out.println("2. View logged activities");
            System.out.println("3. Calculate total time spent on sports");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    logActivity(scanner);
                    break;
                case 2:
                    viewActivities();
                    break;
                case 3:
                    calculateTotalTime();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Sports Activity Logger!");
    }
}
