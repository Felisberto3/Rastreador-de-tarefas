package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;

public class TaskModel {
    private static Gson gson = new Gson();
    private static Path path = Paths.get("").toAbsolutePath().resolve("src/db.json");

    private static void create() throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }

    private static boolean save(List<Task> tasks) throws JsonIOException, IOException {
        create();

        try (FileWriter writer = new FileWriter(path.toString())) {
            gson.toJson(tasks, writer);
            return true;
        } catch (JsonIOException e) {
            System.out.println(e.getMessage());
            throw new JsonIOException("Erro ao escrever as tasks no db ");
        } catch (IOException e) {
            throw new JsonIOException("Erro escrever no arquivo  " + path);
        }

    }

    public static List<Task> allTasks() throws IOException, JsonIOException {
        create();
        ArrayList<Task> tasksList = new ArrayList<>();

        try (FileReader reader = new FileReader(path.toString())) {
            Task[] tasks = gson.fromJson(reader, Task[].class);

            if (tasks == null)
                return tasksList;

            tasksList = new ArrayList<>(Arrays.asList(tasks));

            return tasksList;

        } catch (IOException e) {
            throw new IOException("Erro ao ler o arquivo " + path);
        } catch (JsonParseException e) {
            throw new JsonIOException("Erro ao trasformar objectos em json  " + path);
        }
    }

    public static void add(Task newTask) throws JsonIOException, IOException {
        List<Task> tasks = allTasks();
        tasks.add(newTask);
        save(tasks);
        System.out.println("Task added successfully (ID: " + newTask.getId() + ")");
    }

    public static void update(int id, String field, String value) throws JsonIOException, IOException {
        List<Task> tasks = allTasks();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                Task taskToUpdate = tasks.get(i);

                if (field.equals("status"))
                    taskToUpdate.setStatus(value);

                if (field.equals("description"))
                    taskToUpdate.setDescription(value);

                taskToUpdate.setUpdatedAt(LocalDateTime.now().toString());
                save(tasks);
                System.out.println("Updating tasks");
                return;
            }
        }
        System.out.println("Id Task does not exist, please try again!");
    }

    public static void delete(int id) throws JsonIOException, IOException {
        List<Task> tasks = allTasks();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                save(tasks);
                System.out.println("Deleting tasks!!!! ");
                return;
            }
        }
        System.out.println("Id Task does not exist, please try again!");
    }
}
