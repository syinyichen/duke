package duke;

import java.io.*;
import duke.Ui;
import duke.Parser;
import duke.TaskList;
import duke.Storage;
import duke.DukeException;

/**
 * <code>Duke</code> is a chatbox that keep tracks of various tasks.
 */
public class Duke {
    private Ui ui;
    private Parser parser;
    private TaskList taskList;
    private Storage storage;

    /**
     * Launch a new <code>UI</code> to interact with user.
     * Indicates the <code>filePath</code> to store tasks.
     *
     * @throws FileNotFoundException  If file is not found in the given <code>filePath</code>.
     */
    public Duke(String filePath) throws FileNotFoundException {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.load(), ui);
        } catch (DukeException e) {
            ui.showLoadingError();
            taskList = new TaskList(ui);
        }
    }

    /**
     * Chatbox starts by greeting user.
     * <code>Parser</code> is used to scan user input.
     * Various tasks are carried out based on the user input.
     * Tasks are stored in a file.
     *
     * @throws IOException  If file is unavailable for writing in <code>Storage</code>
     */
    public void run() throws IOException {
        ui.greet();
        parser = new Parser(ui, taskList);
        parser.run();
        storage.writeStorage(taskList);
    }

    public static void main(String[] args) throws IOException {
        new Duke("C:/Users/syiny/Desktop/Study/CS2103T/duke/data/duke.txt").run();
    }
}
