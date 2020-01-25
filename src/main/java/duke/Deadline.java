package duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline.
 */
public class Deadline extends Task {
    LocalDateTime time;

    public Deadline(String instr, LocalDateTime time) {
        super(instr);
        this.time = time;
    }

    /**
     * Getter for the <code>time</code> of <code>Deadline</code>.
     */
    public LocalDateTime getTime() {
        return time;
    }

    public String toString() {
        if (super.done) {
            return "[D][DONE]" + super.instr;
        } else {
            return "[D][INCOMPLETE]" + super.instr + " (by: "
                    + time.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm")) + ")";
        }
    }
}
