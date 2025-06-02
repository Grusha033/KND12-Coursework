package view.console.menu;

import memory.Todos;
import view.console.commands.MenuCommand;
import view.console.commands.SwitchScreenCommand;
import view.console.components.ConsoleInput;
import view.console.components.Screen;

import java.util.Map;
import java.util.Scanner;

public class TasksMenu implements Screen
{
    private final Scanner scanner;
    private final Todos todos;

    private final Map<Integer, MenuCommand> commands;

    private final String label =
            "========= TASKS =========\n" +
            "1. Create task\n" +
            "2. Edit task\n" +
            "3. Sort tasks\n" +
            "4. Filter tasks\n\n" +
            "5. Back\n" +
            "=========================";

    public TasksMenu(Scanner scanner, Todos todos)
    {
        this.scanner = scanner;
        this.todos = todos;

        commands = Map.of(
                1, new SwitchScreenCommand(() -> new CreateTaskMenu(scanner, todos)),
                2, new SwitchScreenCommand(() -> new EditTaskMenu(scanner, todos,
                        ConsoleInput.readInteger(scanner, "CHOOSE TASK ID", todos.getTasks().size() - 1))),
                3, new SwitchScreenCommand(() -> new SortMenu(scanner, todos)),
                4, new SwitchScreenCommand(() -> new FilterMenu(scanner, todos)),
                5, new SwitchScreenCommand(() -> new MainMenu(scanner, todos))
        );
    }

    @Override
    public void draw()
    {
        System.out.println(label);
    }

    @Override
    public Screen interact()
    {
        int choice = ConsoleInput.readInteger(scanner, "CHOICE", commands.size());

        return commands.get(choice).execute();
    }
}
