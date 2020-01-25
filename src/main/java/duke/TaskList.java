package duke;

import duke.Task;
import duke.Ui;
import duke.DukeException;
import duke.Todo;
import duke.Deadline;
import duke.Event;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;
    private Ui ui;

    public TaskList(Ui ui) {
        this.taskList = new ArrayList<Task>();
        this.ui = ui;
    }

    public TaskList(ArrayList<Task> taskList, Ui ui) {
        this.taskList = taskList;
        this.ui = ui;
    }

    public void delete(int index) {
        try {
            if (index <= taskList.size()) {
                Task delTask = taskList.get(index - 1);
                taskList.remove(index - 1);
                ui.delete(delTask, taskList.size());
            } else {
                throw new DukeException("Invalid Task Index");
            }
        } catch (DukeException ex) {
            ui.showInvalidTaskIndex();
        }
    }

    public void done(int index) {
        try {
            if (index <= taskList.size()) {
                Task doneTask = taskList.get(index - 1);
                doneTask.done();
                ui.done(doneTask);
            } else {
                throw new DukeException("Invalid Task Index");
            }
        } catch (DukeException ex) {
            ui.showInvalidTaskIndex();
        }
    }

    public void addTodo(String instr) {
        try {
            if (!instr.isEmpty()) {
                Todo newTask = new Todo(instr);
                taskList.add(newTask);
                ui.addTask(newTask, taskList.size());
            } else {
                throw new DukeException("Invalid Done Description");
            }
        } catch (DukeException ex) {
            ui.showInvalidTodoDesc();
        }
    }

    public void addDeadline(String instr) {
        try {
            if (!instr.isEmpty()) {
                String[] splitTime = instr.split(" /by ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
                Deadline newTask = new Deadline(splitTime[0],
                        LocalDateTime.parse(splitTime[1], formatter));
                taskList.add(newTask);
                ui.addTask(newTask, taskList.size());
            } else {
                throw new DukeException("Invalid Deadline Description");
            }
        } catch (DukeException ex) {
            ui.showInvalidDeadlineDesc();
        }
    }

    public void addEvent(String instr) {
        try {
            if (!instr.isEmpty()) {
                String[] splitTime = instr.split(" /at ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
                Event newTask = new Event(splitTime[0], LocalDateTime.parse(splitTime[1], formatter));
                taskList.add(newTask);
                ui.addTask(newTask, taskList.size());
            } else {
                throw new DukeException("Invalid Event Description");
            }
        } catch (DukeException ex) {
            ui.showInvalidEventDesc();
        }
    }

    public ArrayList<Task> find(String keyword) {
        ArrayList<Task> foundList = new ArrayList<Task>();
        for (Task t: taskList) {
            if (t.getInstr().contains(keyword)) {
                foundList.add(t);
            }
        }
        return foundList;
    }

    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < taskList.size(); i++) {
            output += i + 1 + ". " + taskList.get(i).toString() + "\n";
        }
        return output;
    }
}
