package model;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.JsonIOException;

public class TaskControll {
    Scanner scan = new Scanner(System.in);

    public void menu() throws JsonIOException, IOException {
        String commandLine = scan.nextLine();

        String[] args = commandLine.split(" ");

        if (args.length < 2)
            return;

        String task_cli = args[0];
        String method = args[1];

        if (!task_cli.equals("task-cli")) {
            System.out.println("'" + commandLine + "' Não existe em Task-cli");
            return;
        }

        if (method.equals("add")) {
            String value = args[2].trim();

            if (value.length() > 2)
                TaskModel.add(new Task(value, "todo"));

        } else if (method.equals("delete")) {
            int id = Integer.parseInt(args[2]);
            TaskModel.delete(id);

        } else if (method.equals("update")) {
            int id = Integer.parseInt(args[2]);
            String value = args[3].trim();

            if (value.length() > 2)
                TaskModel.update(id, "description", value);

        } else if (method.equals("mark-in-progress") || method.equals("mark-done")) {
            int id = Integer.parseInt(args[2]);
            String value = method.equals("mark-in-progress") ? "In-progress" : "done";

            if (value.length() > 2)
                TaskModel.update(id, "status", value);
        }

    }

}
