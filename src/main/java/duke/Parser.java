package duke;

import duke.Ui;
import duke.TaskList;
import duke.DukeException;
import java.util.Scanner;

public class Parser {
    private Scanner sc;
    private Ui ui;
    private TaskList taskList;

    public Parser(Ui ui, TaskList taskList) {
        sc = new Scanner(System.in);
        this.ui = ui;
        this.taskList = taskList;
    }

    public void run() {
        while (sc.hasNextLine()) {
            String command = sc.next();
            if (command.equals("bye")) {
                ui.bye();
                break;
            } else if (command.equals("list")) {
                ui.list(taskList);
            } else {
                try {
                    if (command.equals("delete")) {
                        int n = sc.nextInt();
                        taskList.delete(n);
                    } else if (command.equals("done")) {
                        int n = sc.nextInt();
                        taskList.done(n);
                    } else if (command.equals("todo")) {
                        String input = sc.nextLine();
                        taskList.addTodo(input);
                    } else if (command.equals("deadline")) {
                        String input = sc.nextLine();
                        taskList.addDeadline(input);
                    } else if (command.equals("event")) {
                        String input = sc.nextLine();
                        taskList.addEvent(input);
                    } else {
                        throw new DukeException("Invalid Command");
                    }
                } catch (DukeException ex) {
                    ui.showInvalidCommand();
                }
            }
        }
    }
}
