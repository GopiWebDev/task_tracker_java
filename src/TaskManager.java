import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TaskManager  {
    private static final String FILE_NAME = "tasks.json";
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayList<Task> tasks;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public TaskManager(){
        this.tasks = this.loadTasks();
    }

    private ArrayList<Task> loadTasks() {
        File file = new File(FILE_NAME);
        if(file.exists() && file.length() > 0){
            try {
                 ArrayList<Task> loadedTask = objectMapper.readValue(file, new TypeReference<>() {});
                 if(!loadedTask.isEmpty()){
                     int maxId = loadedTask.stream().mapToInt(Task::getId).max().orElse(0);
                     Task.setCounter(maxId + 1);
                 }

                 return loadedTask;
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
            targetTask.setUpdatedAt(LocalDateTime.now().format(FORMATTER));
            System.out.println("Task updated successfully");
            this.updateTaskList();
        } else {
            System.out.println("Task with ID: " + id + " not found");
        }
    }

    void deleteTask(int id) throws IOException {
        boolean removed = tasks.removeIf(task -> task.getId() == id);

        if(removed){
            this.updateTaskList();
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Task with ID: " + id + " not found");
        }
    }

    void markInProgress(int id) throws IOException {
        Task targetTask = getTask(id);

        if(targetTask != null){
            targetTask.setStatus(TaskStatus.IN_PROGRESS);
            targetTask.setUpdatedAt(LocalDateTime.now().format(FORMATTER));
            this.updateTaskList();
        }
    }

    void markDone(int id) throws IOException {
        Task targetTask = getTask(id);

        if(targetTask != null){
            targetTask.setStatus(TaskStatus.DONE);
            targetTask.setUpdatedAt(LocalDateTime.now().format(FORMATTER));
            this.updateTaskList();
        }
    }

    Task getTask(int id){
        return this.tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    void getTaskList(){
        this.tasks.forEach(System.out::println);
    }

    private void updateTaskList() throws IOException {
        try {
            objectMapper.writeValue(new File(FILE_NAME), tasks);
        } catch (IOException e) {
            System.out.println("❌ Error saving tasks: " + e.getMessage());
        }

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
