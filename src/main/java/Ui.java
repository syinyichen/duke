public class Ui {
    String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    String line = "____________________________________________________________";

    public Ui() { }

    //Responses
    public void greet() {
        System.out.println(line + "\nHello! I'm Duke\nWhat can I do for you?\n" + line);
    }

    public void bye() {
        System.out.println(line + "\nBye. Hope to see you again soon!\n" + line);
    }

    public void list(TaskList taskList) {
        System.out.println(line + "\nHere are the tasks in your list: \n" + taskList + line);
    }

    public void delete(Task delTask, int totalTask) {
        System.out.println(line + "\nNoted. I've removed this task: \n" + delTask
                + "\nNow you have " + totalTask + " tasks in the list.\n" + line);
    }

    public void done(Task doneTask) {
        System.out.println(line + "\nNice! I've marked this task as done: \n" + doneTask + "\n"
                + line);
    }

    public void addTask(Task newTask, int totalTask) {
        System.out.println(line + "\n" + "Got it. I've added this task: \n" + newTask
                + "\nNow you have " + totalTask + " tasks in the list.\n" + line);
    }

    //Print exceptions
    public void showLoadingError() {
        System.out.println(line + "\n" + "OOPS!!! Unable to read the tasks in the file.\n" + line);
    }

    public void showInvalidCommand() {
        System.out.println(line + "\n" + "OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                + line);
    }

    public void showInvalidTaskIndex() {
        System.out.println(line + "\n" + "OOPS!!! The task is unavailable.\n" + line);
    }

    public void showInvalidTodoDesc() {
        System.out.println(line + "\n" + "OOPS!!! The description of a todo cannot be empty.\n"
                + line);
    }

    public void showInvalidDeadlineDesc() {
        System.out.println(line + "\n" + "OOPS!!! The description of a deadline cannot be empty.\n"
                + line);
    }

    public void showInvalidEventDesc() {
        System.out.println(line + "\n" + "OOPS!!! The description of a deadline cannot be empty.\n"
                + line);
    }
}
