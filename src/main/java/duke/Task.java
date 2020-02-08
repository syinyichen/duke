package duke;

import java.time.LocalDateTime;

/**
 * Represents a task which an user input in the <code>Duke</code> chatbox.
 * A <code>Task</code> consists of 2 components:
 * <code>instr</code> (instructions), which describes the task required to be carried out and
 * <code>done</code>, which describes the status of the task (whether it is completed).
 */
public class Task {
    String instr;
    String type;
    boolean done;

    public Task(String instr) {
        this.instr = instr;
        this.type = "TASK";
        this.done = false;
    }

    /**
     * Changes the <code>Task</code>'s status to <code>done</code> when the task is completed.
     */
    public void done() {
        this.done = true;
    }

    /**
     * Changes the <code>Task</code>'s status to <code>incomplete</code>.
     */
    public void undone() {
        this.done = false;
    }

    /**
     * Getter for <code>instr</code> (instruction), the description of the task.
     */
    public String getInstr() {
        return instr;
    }

    /**
     * Getter for <code>type</code> (instruction), the type of the task.
     */
    public String getType() {
        return type;
    }

    /**
     * Indicates if the task is completed. Returns <code>true</code> when task is done.
     */
    public boolean isDone() {
        return done;
    }

    @Override
    public String toString() {
        if (done) {
            return "[\u2713] " + this.instr;
        } else {
            return "[\u2718] " + this.instr;
        }
    }
}
