import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    LocalDateTime time;

    public Event(String instr, LocalDateTime time) {
        super(instr);
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String toString() {
        if (super.done) {
            return "[E][DONE]" + super.instr;
        } else {
            return "[E][INCOMPLETE]" + super.instr + " (at: "
                    + time.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm")) + ")";
        }
    }
}