package view.console.components;

import model.Todos;
import view.console.menu.MainMenu;
import view.console.view.TodoView;

import java.util.Scanner;

public class ConsoleView
{
    private Screen currentScreen;
    private final TodoView todoView;

    public ConsoleView(Todos todos)
    {
        this.todoView = new TodoView(todos);

        Scanner scanner = new Scanner(System.in);
        currentScreen = new MainMenu(scanner, todos);
    }

    public void start()
    {
        while (currentScreen != null)
        {
            clearConsole();
            todoView.show();
            currentScreen.draw();
            currentScreen = currentScreen.interact();
        }
    }

    public static void clearConsole()
    {
        System.out.print("\n".repeat(200));
    }
}
