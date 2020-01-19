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

        while (sc.hasNextLine()) {
            String input = sc.nextLine();

            if (input.equals("bye")) {
                System.out.println(line + "\nBye. Hope to see you again soon!\n" + line);
                break;
            } else if (input.equals("list")) {
                System.out.println(line + "\nHere are the tasks in your list: ");
                for (int i = 0; i < tasks.size(); i++) {
                    printStream.println(i + 1 + ". " + tasks.get(i));
                }
                System.out.println(line);
            }   else {
                String[] inputArr = input.split(" ");
                if (inputArr[0].equals("done")) {
                    Task doneTask = tasks.get(Integer.parseInt(inputArr[1]) - 1);
                    doneTask.done();
                    printStream.println(line + "\nNice! I've marked this task as done: \n" + doneTask + "\n" + line);
                } else {
                    Task newTask = new Task(input);
                    tasks.add(newTask);
                    System.out.println(line + "\n" + "added: " + input + "\n" + line);
                }
            }
        }
    }
}
