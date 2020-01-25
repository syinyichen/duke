import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private ArrayList<Task> taskList;
    private String filePath;
    private File file;
    private Scanner scFile;

    public Storage(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        this.file = new File(filePath);
        scFile = new Scanner(file);
        this.taskList = new ArrayList<Task>();
    }

    public ArrayList<Task> load() throws DukeException {
        while (scFile.hasNextLine()) {
            String fileInput = scFile.nextLine();
            String[] splitted = fileInput.split(" \\| ");
            if (splitted[0].equals("T")) {
                Todo newTask = new Todo(" " + splitted[2]);
                if (splitted[1].equals("1")) {
                    newTask.done();
                }
                taskList.add(newTask);
            } else if (splitted[0].equals("D")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
                Deadline newTask = new Deadline(" " + splitted[2],
                        LocalDateTime.parse(splitted[3], formatter));
                if (splitted[1].equals("1")) {
                    newTask.done();
                }
                taskList.add(newTask);
            } else if (splitted[0].equals("E")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
                Event newTask = new Event(" " + splitted[2],
                        LocalDateTime.parse(splitted[3], formatter));
                if (splitted[1].equals("1")) {
                    newTask.done();
                }
                taskList.add(newTask);
            } else {
                throw new DukeException("Unable to read task in file");
            }
        }
        return this.taskList;
    }

    public void writeStorage(TaskList tasks) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        for (Task t: tasks.getTaskList()) {
            int isDone = 0;
            if (t.isDone()) {
                isDone = 1;
            }
            if (t instanceof Todo) {
                fileWriter.write("T | " + isDone + " |" + t.getInstr() + System.lineSeparator());
            } else if (t instanceof Deadline) {
                fileWriter.write("D | " + isDone + " |" + t.getInstr() + " | "
                        + ((Deadline) t).getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"))
                        + System.lineSeparator());
            } else if (t instanceof Event) {
                fileWriter.write("E | " + isDone + " |" + t.getInstr() + " | "
                        + ((Event) t).getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"))
                        + System.lineSeparator());
            }
        }
        fileWriter.close();
    }
}
