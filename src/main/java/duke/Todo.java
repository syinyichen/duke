package duke;

/**
 * Represents a to-do.
 */
public class Todo extends Task {
    public Todo (String instr) {
        super(instr);
    }

    @Override
    public String toString() {
        if (super.done) {
            return "[T][DONE]" + super.instr;
        } else {
            return "[T][INCOMPLETE]" + super.instr;
        }
    }
}
