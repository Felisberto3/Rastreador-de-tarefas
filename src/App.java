import model.Task;
import model.TaskControll;
import model.TaskModel;

public class App {
    public static void main(String[] args) {
        try {
            // TaskController a = new TaskController();

            TaskControll a = new TaskControll();

            a.menu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
