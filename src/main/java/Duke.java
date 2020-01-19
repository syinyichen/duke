import java.util.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Duke {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String line = "____________________________________________________________";
        ArrayList<Task> tasks = new ArrayList<Task>();
        Scanner sc = new Scanner(System.in);
        PrintStream printStream = new PrintStream(System.out, true, "UTF-8");;

        //Greeting
        System.out.println(line + "\nHello! I'm Duke\nWhat can I do for you?\n" + line);

        //Tasks
        while (sc.hasNextLine()) {
            String command = sc.next();

            if (command.equals("bye")) {
                System.out.println(line + "\nBye. Hope to see you again soon!\n" + line);
                break;
            } else if (command.equals("list")) {
                System.out.println(line + "\nHere are the tasks in your list: ");
                for (int i = 0; i < tasks.size(); i++) {
                    printStream.println(i + 1 + ". " + tasks.get(i));
                }
                System.out.println(line);
            } else {
                if (command.equals("done")) {
                    Task doneTask = tasks.get(sc.nextInt() - 1);
                    doneTask.done();
                    printStream.println(line + "\nNice! I've marked this task as done: \n" + doneTask + "\n" + line);
                } else if (command.equals("todo")) {
                    String input = sc.nextLine();
                    Todo newTask = new Todo(input);
                    tasks.add(newTask);
                    System.out.println(line + "\n" + "Got it. I've added this task: \n" + newTask
                            + "\nNow you have " + tasks.size() + " tasks in the list.\n" + line);
                } else if (command.equals("deadline")) {
                    String input = sc.nextLine();
                    String[] splitTime = input.split(" /by ");
                    Deadline newTask = new Deadline(splitTime[0], splitTime[1]);
                    tasks.add(newTask);
                    System.out.println(line + "\n" + "Got it. I've added this task: \n" + newTask
                            + "\nNow you have " + tasks.size() + " tasks in the list.\n" + line);
                } else if (command.equals("event")) {
                    String input = sc.nextLine();
                    String[] splitTime = input.split(" /at ");
                    Event newTask = new Event(splitTime[0], splitTime[1]);
                    tasks.add(newTask);
                    System.out.println(line + "\n" + "Got it. I've added this task: \n" + newTask
                            + "\nNow you have " + tasks.size() + " tasks in the list.\n" + line);
                }
            }
        }

    }
}
