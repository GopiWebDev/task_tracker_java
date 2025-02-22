import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private static int counter = 1;
    private int id;
    private String description;
    private TaskStatus status;
    private String createdAt;
    private String updatedAt;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Task(){}

    public Task(String description){
        this.id = counter++;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.createdAt = LocalDateTime.now().format(FORMATTER);
        this.updatedAt = LocalDateTime.now().format(FORMATTER);
    }

    public int getId(){
        return this.id;
    };

    public String getDescription(){
        return this.description;
    }

    void setDescription(String description){
        this.description = description;
    }

    public TaskStatus getStatus(){
        return this.status;
    }

    void setStatus(TaskStatus status){
        this.status = status;
        this.updatedAt = LocalDateTime.now().format(FORMATTER);
    }

    public String getCreatedAt(){
        return this.createdAt;
    }

    public String getUpdatedAt(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return this.updatedAt;
    }

    void setUpdatedAt(LocalDateTime dateTime){
        this.updatedAt = dateTime.format(FORMATTER);
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Description: " + description + ", Status: " + status + ", Created At: " + createdAt + ", Updated At: " + updatedAt;
    }
}

enum TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE,
    NOT_DONE
}
