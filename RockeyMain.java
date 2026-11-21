import java.util.ArrayList;
import java.util.Scanner;

class ProjectTask {

    int taskId;
    String title;
    String status = "Not Started";

    ProjectTask(int taskId, String title) {
        this.taskId = taskId;
        this.title = title;
    }
}

class StatusTracker {

    ArrayList<ProjectTask> tasks = new ArrayList<>();

    void addTask(int id, String title) {

        tasks.add(new ProjectTask(id, title));
        System.out.println("Task added successfully!");
    }

    void updateStatus(int id, String status) {

        for (ProjectTask t : tasks) {

            if (t.taskId == id) {

                if (status.equalsIgnoreCase("Completed")) {
                    t.status = "Completed";
                }
                else if (status.equalsIgnoreCase("In Progress")) {
                    t.status = "In Progress";
                }
                else if (status.equalsIgnoreCase("Not Started")) {
                    t.status = "Not Started";
                }
                else {
                    System.out.println("Invalid status!");
                    return;
                }

                System.out.println("Status updated successfully!");
                return;
            }
        }

        System.out.println("Task not found!");
    }

    void viewTasks() {

        for (ProjectTask t : tasks) {

            System.out.println("Task ID: " + t.taskId);
            System.out.println("Title: " + t.title);
            System.out.println("Status: " + t.status);
            System.out.println("----------------");
        }
    }

    void generateReport() {

        int total = tasks.size();
        int completed = 0;
        int progress = 0;
        int pending = 0;

        for (ProjectTask t : tasks) {

            if (t.status.equals("Completed")) {
                completed++;
            }
            else if (t.status.equals("In Progress")) {
                progress++;
            }
            else {
                pending++;
            }
        }

        System.out.println("\n--- BRIGHTTECH PROJECT REPORT ---");
        System.out.println("Total Tasks: " + total);
        System.out.println("Completed Tasks: " + completed);
        System.out.println("In Progress Tasks: " + progress);
        System.out.println("Not Started Tasks: " + pending);
    }
}

public class RockeyMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StatusTracker tracker = new StatusTracker();

        while (true) {

            System.out.println("\n--- ROCKEY STATUS TRACKER ---");
            System.out.println("1. Add Task");
            System.out.println("2. Update Status");
            System.out.println("3. View Tasks");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Task ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Task Title: ");
                    String title = sc.nextLine();

                    tracker.addTask(id, title);
                    break;

                case 2:
                    System.out.print("Task ID: ");
                    id = Integer.parseInt(sc.nextLine());

                    System.out.print("Status (Not Started/In Progress/Completed): ");
                    String status = sc.nextLine();

                    tracker.updateStatus(id, status);
                    break;

                case 3:
                    tracker.viewTasks();
                    break;

                case 4:
                    tracker.generateReport();
                    break;

                case 5:
                    System.out.println("Rockey module completed!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}