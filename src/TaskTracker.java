
import java.io.IOException;

public class TaskTracker {
    public static void main(String[] args) throws IOException {
        TaskManager manager = new TaskManager();

        if(args.length < 1){
            System.out.println("""
                    Instructions:
                    To add a task: java TaskTracker add <description>
                    To update a task: java TaskTracker update <id> <updated description>
                    To delete a task: java TaskTracker delete <id>
                    To mark in progress: java TaskTracker mark-in-progress <id>
                    To mark done: java TaskTracker mark-done <id>
                    To list all tasks: java TaskTracker list
                    To list by status: java TaskTracker list <done | todo | in-progress>
                    """);
            System.exit(0);
        }

        String command = args[0].toLowerCase();

        switch (command){
            case "add" -> {
                if(args[1] != null){
                    manager.addTask(args[1]);
                } else {
                    System.out.println("USE: add <description>");
                }
            }
            case "update" -> {
                if(args[1] != null && args[2] != null){
                    manager.updateTask(Integer.parseInt(args[1]), args[2]);
                } else {
                    System.out.println("USE: update <id> <description>");
                }
            }
            case "delete" -> {
                if(args[1] != null){
                    manager.deleteTask(Integer.parseInt(args[1]));
                } else {
                    System.out.println("USE: delete <id>");
                }
            }
            case "mark-in-progress" -> {
                if(args[1] != null){
                    manager.markInProgress(Integer.parseInt(args[1]));
                } else {
                    System.out.println("USE: mark-in-progress <id>");
                }
            }
            case "done" -> {
                if(args[1] != null){
                    manager.markDone(Integer.parseInt(args[1]));
                } else {
                    System.out.println("USE: mark-done <id>");
                }
            }
            case "list" -> {
                if(args[1] != null){
                    if(args[2] == null){
                        manager.getTaskList();
                    } else if (args[2].equals("done")){
                        manager.getTaskList(TaskStatus.DONE);
                    } else if (args[2].equals("todo")){
                        manager.getTaskList(TaskStatus.TODO);
                    } else if (args[2].equals("in-progress")){
                        manager.getTaskList(TaskStatus.IN_PROGRESS);
                    } else {
                        System.out.println("USE: list <done | todo | in-progress>");
                    }
                } else {
                    System.out.println("USE: list");
                }
            }
            default -> System.out.println("Invalid Command");
        }
    }
}

