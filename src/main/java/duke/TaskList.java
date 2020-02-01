package duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Represents the list which stores the tasks input by the user.
 */
public class TaskList {
    private ArrayList<Task> taskList;
    private Ui ui;

    public TaskList(Ui ui) {
        this.taskList = new ArrayList<Task>();
        this.ui = ui;
    }

    public TaskList(ArrayList<Task> taskList, Ui ui) {
        this.taskList = taskList;
        this.ui = ui;
    }

    /**
     * Delete a task from the list based on the index input by the user.
     *
     * @param index Index of a task in the list.
     * @throws DukeException If the index input is unavailable in the list of tasks.
     */
    public String delete(int index) {
        String output = "";
        try {
            if (index <= taskList.size()) {
                Task delTask = taskList.get(index - 1);
                taskList.remove(index - 1);
                output = ui.delete(delTask, taskList.size());
            } else {
                throw new DukeException("Invalid Task Index");
            }
        } catch (DukeException ex) {
            output = ui.showInvalidTaskIndex();
        }
        return output;
    }

    /**
     * Changes the indicated task's status to <code>done</code>.
     *
     * @param index Index of a task in the list.
     * @throws DukeException If the index input is unavailable in the list of tasks.
     */
    public String done(int index) {
        String output = "";
        try {
            if (index <= taskList.size()) {
                Task doneTask = taskList.get(index - 1);
                doneTask.done();
                output = ui.done(doneTask);
            } else {
                throw new DukeException("Invalid Task Index");
            }
        } catch (DukeException ex) {
            output = ui.showInvalidTaskIndex();
        }
        return output;
    }

    /**
     * Adds a new to-do into the tasks list.
     *
     * @param instr Description of the to-do.
     * @throws DukeException If the description of the to-do is empty.
     */
    public String addTodo(String instr) {
        String output = "";
        try {
            if (!instr.isEmpty()) {
                Todo newTask = new Todo(instr);
                taskList.add(newTask);
                output = ui.addTask(newTask, taskList.size());
            } else {
                throw new DukeException("Invalid Todo Description");
            }
        } catch (DukeException ex) {
           output = ui.showInvalidDesc();
        }
        return output;
    }

    /**
     * Adds a new deadline into the tasks list.
     *
     * @param instr Description of the deadline.
     * @throws DukeException If the description of the deadline is empty.
     */
    public String addDeadline(String instr) {
        String output = "";
        try {
            if (!instr.isEmpty()) {
                String[] splitTime = instr.split(" /by ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
                Deadline newTask = new Deadline(splitTime[0],
                        LocalDateTime.parse(splitTime[1], formatter));
                taskList.add(newTask);
                output = ui.addTask(newTask, taskList.size());
            } else {
                throw new DukeException("Invalid Deadline Description");
            }
        } catch (DukeException ex) {
            output = ui.showInvalidDesc();
        }
        return output;
    }

    /**
     * Adds a new event into the tasks list.
     *
     * @param instr Description of the event.
     * @throws DukeException If the description of the event is empty.
     */
    public String addEvent(String instr) {
        String output = "";
        try {
            if (!instr.isEmpty()) {
                String[] splitTime = instr.split(" /at ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
                Event newTask = new Event(splitTime[0],
                        LocalDateTime.parse(splitTime[1], formatter));
                taskList.add(newTask);
                output = ui.addTask(newTask, taskList.size());
            } else {
                throw new DukeException("Invalid Event Description");
            }
        } catch (DukeException ex) {
            output = ui.showInvalidDesc();
        }
        return output;
    }

    /**
     * Returns a list of tasks that contains the <code>keyword</code>.
     *
     * @param keyword Search keyword.
     */
    public ArrayList<Task> find(String keyword) {
        ArrayList<Task> foundList = new ArrayList<Task>();
        for (Task t: taskList) {
            if (t.getInstr().contains(keyword)) {
                foundList.add(t);
            }
        }
        return foundList;
    }

    /**
     * A getter for the list.
     */
    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < taskList.size(); i++) {
            output += i + 1 + ". " + taskList.get(i).toString() + "\n";
        }
        return output;
    }
}
