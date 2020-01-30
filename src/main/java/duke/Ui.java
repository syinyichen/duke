package duke;

import duke.Task;

import java.io.FileNotFoundException;

/**
 * Represents the user interface. <code>Ui</code> outputs messages and interacts with the user.
 */
public class Ui {
    String line = "____________________________________________________________";

    public Ui() {

    }

    //Responses
    /**
     * Greets the user when <code>Duke</code> is launched.
     */
    public void greet() {
        System.out.println(line + "\nHello! I'm Duke\nWhat can I do for you?\n" + line);
    }

    /**
     * Bids farewell after the user input "bye".
     */
    public void bye() {
        System.out.println(line + "\nBye. Hope to see you again soon!\n" + line);
    }

    /**
     * Prints the list of tasks in the order of input.
     *
     * @param taskList A list which stores the tasks input by the user.
     */
    public void list(TaskList taskList) {
        System.out.println(line + "\nHere are the tasks in your list: \n" + taskList
                + line);
    }

    /**
     * Prints the list of search results.
     *
     * @param taskList List of tasks.
     */
    public void findList(TaskList taskList) {
        System.out.println(line + "\nHere are the matching tasks in your list: \n" + taskList + line);
    }

    /**
     * Prints a message to notify the user that a task is deleted.
     *
     * @param delTask Task to be deleted.
     * @param totalTask Total number of tasks in the tasks list.
     */
    public void delete(Task delTask, int totalTask) {
        System.out.println(line + "\nNoted. I've removed this task: \n" + delTask
                + "\nNow you have " + totalTask + " tasks in the list.\n" + line);
    }

    /**
     * Prints a message to notify the user that a task is completed.
     *
     * @param doneTask Task that is completed
     */
    public void done(Task doneTask) {
        System.out.println(line + "\nNice! I've marked this task as done: \n"
                + doneTask + "\n" + line);
    }

    /**
     * Prints a message to notify the user that a new task has been added to the list.
     *
     * @param newTask Task to be added.
     * @param totalTask Total number of tasks in the tasks list.
     */
    public void addTask(Task newTask, int totalTask) {
        System.out.println(line + "\n" + "Got it. I've added this task: \n" + newTask
                + "\nNow you have " + totalTask + " tasks in the list.\n" + line);
    }

    //Print exceptions
    /**
     * Prints a message to warn the user when unable to read a file.
     */
    public void showLoadingError() {
        System.out.println(line + "\n"
                + "OOPS!!! Unable to read the tasks in the file.\n" + line);
    }

    /**
     * Prints a message to warn the user when the system is unable to recognise the command.
     */
    public void showInvalidCommand() {
        System.out.println(line + "\n"
                + "OOPS!!! I'm sorry, but I don't know what that means :-(\n" + line);
    }

    /**
     * Prints a message to warn the user when the index input for a <code>delete</code> or <code>done</code>
     * command is invalid.
     */
    public void showInvalidTaskIndex() {
        System.out.println(line + "\n" + "OOPS!!! The task is unavailable.\n" + line);
    }

    /**
     * Prints a message to warn the user when the description for a to-do is empty.
     */
    public void showInvalidTodoDesc() {
        System.out.println(line + "\n"
                + "OOPS!!! The description of a todo cannot be empty.\n" + line);
    }

    /**
     * Prints a message to warn the user when the description for a deadline is empty.
     */
    public void showInvalidDeadlineDesc() {
        System.out.println(line + "\n"
                + "OOPS!!! The description of a deadline cannot be empty.\n" + line);
    }

    /**
     * Prints a message to warn the user when the description for a event is empty.
     */
    public void showInvalidEventDesc() {
        System.out.println(line + "\n"
                + "OOPS!!! The description of a deadline cannot be empty.\n" + line);
    }
}
