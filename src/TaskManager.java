import java.util.ArrayList;
import java.util.stream.Stream;

public class TaskManager {
    ArrayList<Task> tasks = new ArrayList<Task>();

    void addTask(String description){
        Task task = new Task(description);
        this.tasks.add(task);
    }

    void updateTask(int id, String description) {
        Task targetTask = getTask(id);

        if (targetTask != null) {
            targetTask.description = description;
            System.out.println("Task updated successfully");
        } else {
            System.out.println("Task with ID: " + id + " not found");
        }
    }

    void deleteTask(int id){
        Task targetTask = getTask(id);

        if(targetTask != null){
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Task with ID: " + id + " not found");
        }
    }

    void markInProgress(int id){
        Task targetTask = getTask(id);

        if(targetTask != null){
            targetTask.setStatus(TaskStatus.IN_PROGRESS);
        }
    }

    void markDone(int id){
        Task targetTask = getTask(id);

        if(targetTask != null){
            targetTask.setStatus(TaskStatus.DONE);
        }
    }

    Task getTask(int id){
        return this.tasks.stream().filter(task -> task.id == id).findFirst().orElse(null);
    }

    void getTaskList(){
        this.tasks.forEach(t -> System.out.println(t));
    }

    void getTaskList(TaskStatus filter){
        switch (filter){
            case TODO -> {
                Stream<Task> tasks = this.tasks.stream().filter(task -> task.status == TaskStatus.TODO);
                tasks.forEach(task -> System.out.println(task));
            }
            case IN_PROGRESS -> {
                Stream<Task> tasks = this.tasks.stream().filter(task -> task.status == TaskStatus.IN_PROGRESS);
                tasks.forEach(task -> System.out.println(task));
            }
            case DONE -> {
                Stream<Task> tasks = this.tasks.stream().filter(task -> task.status == TaskStatus.DONE);
                tasks.forEach(task -> System.out.println(task));
            }
            case NOT_DONE -> {
                Stream<Task> tasks = this.tasks.stream().filter(task -> task.status != TaskStatus.DONE);
                tasks.forEach(task -> System.out.println(task));
            }
            default -> this.tasks.forEach(t -> System.out.println(t));
        }
    }
}
