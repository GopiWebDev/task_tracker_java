import java.time.LocalDateTime;

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
        return "Task ID: " + id + ", Description: " + description + ", Status: " + status + ", Created At: " + createdAt + ", Updated At: " + updatedAt;
    }
}

enum TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE;
}
