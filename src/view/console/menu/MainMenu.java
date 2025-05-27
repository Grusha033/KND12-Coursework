package view.console.menu;

import model.Todos;
import view.console.commands.MenuCommand;
import view.console.commands.SwitchScreenCommand;
import view.console.components.ConsoleInput;
import view.console.components.Screen;

import java.util.Map;
import java.util.Scanner;

public class MainMenu implements Screen
{
    private final Scanner scanner;
    private final Todos todos;

    private final Map<Integer, MenuCommand> commands;

    public MainMenu(Scanner scanner, Todos todos)
    {
        this.scanner = scanner;
        this.todos = todos;

        commands = Map.of(
                1, new SwitchScreenCommand(() -> new TasksMenu(scanner, todos)),
                2, () -> null
        );
    }

    private final String label =
            "========== MENU ==========\n" +
            "1. Tasks\n\n" +
            "2. Exit\n" +
            "==========================";

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
