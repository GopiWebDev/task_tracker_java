import java.time.LocalDateTime;

public class Task {
//    id: A unique identifier for the task
//    description: A short description of the task
//    status: The status of the task (todo, in-progress, done)
//    createdAt: The date and time when the task was created
//    updatedAt: The date and time when the task was last updated

    private int id;
    private String description;
    private TaskStatus status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}

enum TaskStatus {
    PENDING,
    IN_PROGRESS,
    DONE
}