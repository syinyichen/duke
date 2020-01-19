public class Deadline extends Task {
    String time;

    public Deadline(String instr, String time) {
        super(instr);
        this.time = time;
    }

    public String toString() {
        if (super.done) {
            return "[D][DONE]" + super.instr;
        } else {
            return "[D][INCOMPLETE]" + super.instr + " (by: " + time + ")";
        }
    }
}
