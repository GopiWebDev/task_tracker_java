import java.time.LocalDateTime;

public class TaskTracker {
    public static void main(String[] args){
        TaskManager manager = new TaskManager();

        if(args.length < 1){
            System.out.println("""
                    Instructions:
                    To add a task: java TaskTracker add <task description>
                    To update a task: java TaskTracker update <id> <updated description>
                    To delete a task: java TaskTracker delete <id>
                    To mark in progress: java TaskTracker mark-in-progress <id>
                    To mark done: java TaskTracker mark-done <id>
                    To list all tasks: java TaskTracker list
                    To list by status: java TaskTracker <done | todo | in-progress>
                    """);
        }

        String command = args[0].toLowerCase();

        switch (command){
            case "add" -> {
                if(args[1] != null){
                    manager.addTask(args[1]);
                } else {
                    System.out.println("USE: add <task description>");
                }
            }
            case "update" -> {

            }
        }
    }
}
