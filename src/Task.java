import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private static int counter = 1;
    private final int id;
    String description;
    TaskStatus status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    Task(String description){
        this.id = counter++;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    int getId(){
        return this.id;
    }

    void setStatus(TaskStatus status){
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "Task ID: " + id + ", Description: " + description + ", Status: " + status + ", Created At: " + createdAt.format(formatter) + ", Updated At: " + updatedAt.format(formatter);
    }
}

enum TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE;
}
