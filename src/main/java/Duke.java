import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class Duke {
    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        File file = new File("C:/Users/syiny/Desktop/Study/CS2103T/duke/data/duke.txt");
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String line = "____________________________________________________________";
        ArrayList<Task> tasks = new ArrayList<Task>();
        Scanner scFile = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        //Read file
        while (scFile.hasNextLine()) {
            String fileInput = scFile.nextLine();
            String[] splitted = fileInput.split(" \\| ");
            if (splitted[0].equals("T")) {
                Todo newTask = new Todo(" " + splitted[2]);
                if (splitted[1].equals("1")) {
                    newTask.done();
                }
                tasks.add(newTask);
            } else if (splitted[0].equals("D")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
                Deadline newTask = new Deadline(" " + splitted[2],
                        LocalDateTime.parse(splitted[3], formatter));
                if (splitted[1].equals("1")) {
                    newTask.done();
                }
                tasks.add(newTask);
            } else if (splitted[0].equals("E")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
                Event newTask = new Event(" " + splitted[2],
                        LocalDateTime.parse(splitted[3], formatter));
                if (splitted[1].equals("1")) {
                    newTask.done();
                }
                tasks.add(newTask);
            }
        }

        //Greeting
        System.out.println(line + "\nHello! I'm Duke\nWhat can I do for you?\n" + line);

        //Input
        while (sc.hasNextLine()) {
            String command = sc.next();
            if (command.equals("bye")) {
                System.out.println(line + "\nBye. Hope to see you again soon!\n" + line);
                break;
            } else if (command.equals("list")) {
                System.out.println(line + "\nHere are the tasks in your list: ");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i + 1 + ". " + tasks.get(i));
                }
                System.out.println(line);
            } else {
                try {
                    if (command.equals("delete")) {
                        int n = sc.nextInt();
                        try {
                            if (n <= tasks.size()) {
                                Task delTask = tasks.get(n - 1);
                                tasks.remove(n - 1);
                                System.out.println(line + "\nNoted. I've removed this task: \n" + delTask
                                        + "\nNow you have " + tasks.size() + " tasks in the list.\n" + line);
                            } else {
                                throw new DukeException("Invalid Task Index");
                            }
                        } catch (DukeException ex) {
                            System.out.println(line + "\n" + "OOPS!!! The task is unavailable.\n" + line);
                        }
                    } else if (command.equals("done")) {
                        int n = sc.nextInt();
                        try {
                            if (n <= tasks.size()) {
                                Task doneTask = tasks.get(n - 1);
                                doneTask.done();
                                System.out.println(line + "\nNice! I've marked this task as done: \n" + doneTask + "\n"
                                        + line);
                            } else {
                                throw new DukeException("Invalid Task Index");
                            }
                        } catch (DukeException ex) {
                            System.out.println(line + "\n" + "OOPS!!! The task is unavailable.\n" + line);
                        }
                    } else if (command.equals("todo")) {
                        String input = sc.nextLine();
                        try {
                            if (!input.isEmpty()) {
                                Todo newTask = new Todo(input);
                                tasks.add(newTask);
                                System.out.println(line + "\n" + "Got it. I've added this task: \n" + newTask
                                        + "\nNow you have " + tasks.size() + " tasks in the list.\n" + line);
                            } else {
                                throw new DukeException("Invalid Done Description");
                            }
                        } catch (DukeException ex) {
                            System.out.println(line + "\n" + "OOPS!!! The description of a todo cannot be empty.\n"
                                    + line);
                        }
                    } else if (command.equals("deadline")) {
                        String input = sc.nextLine();
                        try {
                            if (!input.isEmpty()) {
                                String[] splitTime = input.split(" /by ");
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
                                Deadline newTask = new Deadline(splitTime[0],
                                        LocalDateTime.parse(splitTime[1], formatter));
                                tasks.add(newTask);
                                System.out.println(line + "\n" + "Got it. I've added this task: \n" + newTask
                                        + "\nNow you have " + tasks.size() + " tasks in the list.\n" + line);
                            } else {
                                throw new DukeException("Invalid Deadline Description");
                            }
                        } catch (DukeException ex) {
                            System.out.println(line + "\n" + "OOPS!!! The description of a deadline cannot be empty.\n"
                                    + line);
                        }
                    } else if (command.equals("event")) {
                        String input = sc.nextLine();
                        try {
                            if (!input.isEmpty()) {
                                String[] splitTime = input.split(" /at ");
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
                                Event newTask = new Event(splitTime[0], LocalDateTime.parse(splitTime[1], formatter));
                                tasks.add(newTask);
                                System.out.println(line + "\n" + "Got it. I've added this task: \n" + newTask
                                        + "\nNow you have " + tasks.size() + " tasks in the list.\n" + line);
                            } else {
                                throw new DukeException("Invalid Event Description");
                            }
                        } catch (DukeException ex) {
                            System.out.println(line + "\n" + "OOPS!!! The description of a deadline cannot be empty.\n"
                                    + line);
                        }
                    } else {
                        throw new DukeException("Invalid Command");
                    }
                } catch (DukeException ex) {
                    System.out.println(line + "\n" + "OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                            + line);
                }
            }
        }

        //Write file
        FileWriter fileWriter = new FileWriter(
                "C:/Users/syiny/Desktop/Study/CS2103T/duke/data/duke.txt");
        for (Task t: tasks) {
            int isDone = 0;
            if (t.isDone()) {
                isDone = 1;
            }
            if (t instanceof Todo) {
                fileWriter.write("T | " + isDone + " |" + t.getInstr() + System.lineSeparator());
            } else if (t instanceof Deadline) {
                fileWriter.write("D | " + isDone + " |" + t.getInstr() + " | "
                        + ((Deadline) t).getTime().format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm"))
                        + System.lineSeparator());
            } else if (t instanceof Event) {
                fileWriter.write("E | " + isDone + " |" + t.getInstr() + " | "
                        + ((Event) t).getTime().format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm"))
                        + System.lineSeparator());
            }
        }
        fileWriter.close();
    }
}
