package duke;

/**
 * Represents a to-do.
 */
public class Todo extends Task {
    public Todo(String instr) {
        super(instr);
        super.type = "TODO";
    }

    @Override
    public String toString() {
        if (super.done) {
            return "[T][\u2713] " + super.instr;
        } else {
            return "[T][\u2718] " + super.instr;
        }
    }
}
