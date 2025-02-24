import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private static int counter = 1 ;
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
    public TaskStatus getStatus(){
        return this.status;
    }
    public String getCreatedAt(){
        return this.createdAt;
    }
    public String getUpdatedAt(){
        return this.updatedAt;
    }

    static void setCounter(int maxId){
        counter = maxId;
    }
    void setDescription(String description){
        this.description = description;
    }
    void setStatus(TaskStatus status){
        this.status = status;
        this.updatedAt = LocalDateTime.now().format(FORMATTER);
    }
    void setUpdatedAt(String dateTime){
        this.updatedAt = dateTime;
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
