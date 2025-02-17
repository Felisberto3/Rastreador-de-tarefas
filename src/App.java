import model.Task;
import model.TaskModel;

public class App {
    public static void main(String[] args) {
        try {
            Task newTask = new Task("Codar ate Morrer", "Todo");

            // System.out.println(newTask);

            // TaskModel.add(newTask);
            TaskModel.update(279475577, "description", "done");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
