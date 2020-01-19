import java.util.*;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String line = "____________________________________________________________";
        Scanner sc = new Scanner(System.in);

        //Greeting
        System.out.println(line + "\nHello! I'm Duke\nWhat can I do for you?\n" + line);

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println(line + "\nBye. Hope to see you again soon!\n" + line);
                break;
            }
            System.out.println(line + "\n" + input + "\n" + line);
        }
    }
}
