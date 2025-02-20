import java.util.ArrayList;

public class TaskManager {
    ArrayList<Task> tasks = new ArrayList<Task>();

    void addTask(Task task){
        this.tasks.add(task);
    }

    void deleteTask(int id){
        this.tasks.removeIf(task -> task.getId() == id);
    }

    void getTaskList(){
        for(Task task : this.tasks){
            System.out.println(task);
        }
    }
}
