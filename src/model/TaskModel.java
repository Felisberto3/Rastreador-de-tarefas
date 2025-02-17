package model;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.ietf.jgss.GSSException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;

public class TaskModel {
    private static Gson gson = new Gson();
    private static Path path = Paths.get("").toAbsolutePath().resolve("./src/db.json");

    static private void create() throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }

    static public List<Task> allTasks() throws IOException, JsonIOException {
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

}
