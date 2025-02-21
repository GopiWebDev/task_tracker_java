import java.time.LocalDateTime;
import java.util.Scanner;

public class TaskTracker {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");
        manager.addTask(task1);
        manager.addTask(task2);
        manager.addTask(task3);

        manager.markInProgress(2);
        manager.markDone(3);

        manager.getTaskList(TaskStatus.NOT_DONE);
    }
}
