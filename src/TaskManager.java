import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TaskManager  {
    private static final String FILE_NAME = "tasks.json";
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayList<Task> tasks;

    public TaskManager(){
        this.tasks = this.loadTasks();
    }

    private ArrayList<Task> loadTasks() {
        File file = new File(FILE_NAME);
        if(file.exists()){
            try {
                return objectMapper.readValue(file, new TypeReference<>() {});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    void addTask(String description) throws IOException {
        Task task = new Task(description);
        this.tasks.add(task);
        this.updateTaskList();
    }

    void updateTask(int id, String description) throws IOException {
        Task targetTask = getTask(id);

        if (targetTask != null) {
            targetTask.setDescription(description);
            targetTask.setUpdatedAt(LocalDateTime.now());
            System.out.println("Task updated successfully");
            this.updateTaskList();
        } else {
            System.out.println("Task with ID: " + id + " not found");
        }
    }

    void deleteTask(int id) throws IOException {
        Task targetTask = getTask(id);

        if(targetTask != null){
            System.out.println("Task deleted successfully");
            this.updateTaskList();
        } else {
            System.out.println("Task with ID: " + id + " not found");
        }
    }

    void markInProgress(int id) throws IOException {
        Task targetTask = getTask(id);

        if(targetTask != null){
            targetTask.setStatus(TaskStatus.IN_PROGRESS);
            targetTask.setUpdatedAt(LocalDateTime.now());
            this.updateTaskList();
        }
    }

    void markDone(int id) throws IOException {
        Task targetTask = getTask(id);

        if(targetTask != null){
            targetTask.setStatus(TaskStatus.DONE);
            targetTask.setUpdatedAt(LocalDateTime.now());
            this.updateTaskList();
        }
    }

    Task getTask(int id){
        return this.tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    void getTaskList(){
        this.tasks.forEach(System.out::println);
    }

    private ArrayList<Task> getList(){
        return this.tasks;
    }

    private void updateTaskList() throws IOException {
        objectMapper.writeValue(new File(FILE_NAME), getList());
    }

    void getTaskList(TaskStatus filter){
        switch (filter){
            case TODO -> {
                Stream<Task> tasks = this.tasks.stream().filter(task -> task.getStatus() == TaskStatus.TODO);
                tasks.forEach(System.out::println);
            }
            case IN_PROGRESS -> {
                Stream<Task> tasks = this.tasks.stream().filter(task -> task.getStatus() == TaskStatus.IN_PROGRESS);
                tasks.forEach(System.out::println);
            }
            case DONE -> {
                Stream<Task> tasks = this.tasks.stream().filter(task -> task.getStatus() == TaskStatus.DONE);
                tasks.forEach(System.out::println);
            }
            case NOT_DONE -> {
                Stream<Task> tasks = this.tasks.stream().filter(task -> task.getStatus() != TaskStatus.DONE);
                tasks.forEach(System.out::println);
            }
            default -> this.tasks.forEach(System.out::println);
        }
    }
}
