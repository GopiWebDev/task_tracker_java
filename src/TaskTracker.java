import java.time.LocalDateTime;
import java.util.Scanner;

public class TaskTracker {
    public static void main(String[] args){

        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");
        TaskManager manager = new TaskManager();
        manager.addTask(task1);
        manager.addTask(task2);
        manager.addTask(task3);

        manager.deleteTask(21);

        manager.getTaskList();
    }
}
