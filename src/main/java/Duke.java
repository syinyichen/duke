import java.io.*;

public class Duke {
    private Ui ui;
    private Parser parser;
    private TaskList taskList;
    private Storage storage;

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
