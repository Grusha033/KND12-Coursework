import IO.FileTaskRepository;
import model.Todos;
import view.console.components.ConsoleView;

public class Main {
    public static void main(String[] args)
    {
        String filePath = "/data/todos.txt";
        FileTaskRepository taskRepository = new FileTaskRepository(filePath);

        Todos todos = new Todos(taskRepository.loadTasks());

        ConsoleView consoleView = new ConsoleView(todos);
        consoleView.start();

        taskRepository.saveTasks(todos.getTasks());

        ConsoleView.clearConsole();
        System.out.println("✔ Progress saved.  \n" +
                "Initiating system shutdown...  \n" +
                "Abort: Just playing with you \uD83D\uDE0E  \n" +
                "Goodbye!");
    }
}