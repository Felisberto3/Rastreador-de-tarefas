import model.Task;
import model.TaskModel;

public class App {
    public static void main(String[] args) {
        try {
            Task newTask = new Task("yayayay", "Todo");

            // System.out.println(newTask);

            TaskModel.allTasks();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
