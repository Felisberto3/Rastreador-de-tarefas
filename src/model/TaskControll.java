package model;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.JsonIOException;

public class TaskControll {
    Scanner scan = new Scanner(System.in);

    public void menu() throws JsonIOException, IOException {
        String commandLine = scan.nextLine();

        if (commandLine.trim().indexOf("task-cli") != 0) {
            System.out.println("'" + commandLine + "' Não existe em Task-cli");
            return;
        }

        String[] args = commandLine.split(" ");

        if (args.length < 2)
            return;

        if (args[1].equals("add") && args.length > 2 && args[2].trim().length() > 2) {
            String description = args[2];
            TaskModel.add(new Task(description, "todo"));
        }

        if (args[1].equals("update") && args.length > 3 && args[3].trim().length() > 2) {
            int id = Integer.parseInt(args[2]);
            String value = args[3];
            TaskModel.update(id, "description", value);
        }
    }
}
