# Task Tracker

The **Task Tracker** is a command-line application to manage tasks effectively. You can add, update, delete, and track the status of tasks, as well as list tasks by their status.

Challenge from [Roadmap.sh](https://roadmap.sh/projects/task-tracker)

---

## Features

1. **Add a Task**: Create a new task with a unique ID, description, and default status (`todo`).
2. **Update a Task**: Modify the description of an existing task.
3. **Delete a Task**: Remove a task permanently.
4. **Track Task Status**: Change a task's status to `in-progress` or `done`.
5. **List Tasks**:
    - View all tasks.
    - Filter tasks by their status (`done`, `todo`, `in-progress`).

---

## Installation

1. Ensure you have Java 21 and Maven installed.
2. Clone the repository or download the source code.
3. Navigate to the project directory:
   ```bash
   cd task_tracker_java
   ```
4. Compile the project using Maven:
   ```bash
   mvn clean compile
   ```
5. Run the CLI using:
    ```
   mvn exec:java
   ```

## Usage

1. Adding a New Task:
   ```bash
   mvn exec:java -Dexec.args="add Buy groceries"
   ```
2. Updating an Existing Task:
   ```bash
   mvn exec:java -Dexec.args="update <task_id> New task description"
   ```
   Example:
   ```bash
   mvn exec:java -Dexec.args="update 1 Buy groceries and cook dinner"
   ```
3. Deleting a Task:
   ```bash
   mvn exec:java -Dexec.args="delete <task_id>"
   ```
   Example:
   ```bash
   mvn exec:java -Dexec.args="delete 1"
   ```
4. Marking a Task as In Progress:
   ```bash
   mvn exec:java -Dexec.args="mark-in-progress <task_id>"
   ```
   Example:
   ```bash
    mvn exec:java -Dexec.args="mark-in-progress 1"
   ```
5. Marking a Task as Done:
   ```bash
   mvn exec:java -Dexec.args="mark-done <task_id>"
   ```
   Example:
   ```bash
   mvn exec:java -Dexec.args="mark-done 1"
   ```
6. Listing All Tasks:
   ```bash
   mvn exec:java -Dexec.args="list"
   ```
7. Listing Tasks by Status:
    1. Done Tasks:
   ```bash
   mvn exec:java -Dexec.args="list done"
   ```
    2. Todo Tasks:
   ```bash
   mvn exec:java -Dexec.args="list todo"
   ```
    3. In Progress Tasks:
   ```bash
   mvn exec:java -Dexec.args="list in-progress"
   ```
