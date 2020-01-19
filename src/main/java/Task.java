public class Task {
    private String toDo;
    private boolean done;

    public Task (String toDo) {
        this.toDo = toDo;
        this.done = false;
    }

    public void done() {
        this.done = true;
    }

    @Override
    public String toString() {
        if (done) {
            return "[DONE] " + this.toDo;
        } else {
            return "[INCOMPLETE] " + this.toDo;
        }
    }
}
