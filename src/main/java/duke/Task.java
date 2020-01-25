package duke;

import java.io.FileNotFoundException;

/**
 * Represents a task which an user input in the <code>Duke</code> chatbox.
 * A <code>Task</code> consists of 2 components:
 * <code>instr</code> (instructions), which describes the task required to be carried out and
 * <code>done</code>, which describes the status of the task (whether it is completed).
 */
public class Task {
    String instr;
    boolean done;

    public Task (String instr) {
        this.instr = instr;
        this.done = false;
    }

    /**
     * Changes the <code>Task</code>'s status to <code>done</code> when the task is completed.
     */
    public void done() {
        this.done = true;
    }

    /**
     * Getter for <code>instr</code> (instruction), the description of the task.
     */
    public String getInstr() {
        return instr;
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
            return "[DONE] " + this.instr;
        } else {
            return "[INCOMPLETE] " + this.instr;
        }
    }
}
