package duke;

public class Task {
    String instr;
    boolean done;

    public Task (String instr) {
        this.instr = instr;
        this.done = false;
    }

    public void done() {
        this.done = true;
    }

    public String getInstr() {
        return instr;
    }

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
