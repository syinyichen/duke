public class Event extends Task {
    String time;

    public Event(String instr, String time) {
        super(instr);
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String toString() {
        if (super.done) {
            return "[E][DONE]" + super.instr;
        } else {
            return "[E][INCOMPLETE]" + super.instr + " (at: " + time + ")";
        }
    }
}