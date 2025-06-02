package view.console.menu;

import memory.Todos;
import sorting.Sorting;
import view.console.commands.ActionCommand;
import view.console.commands.MenuCommand;
import view.console.commands.SwitchScreenCommand;
import view.console.components.ConsoleInput;
import view.console.components.Screen;

import java.util.Map;
import java.util.Scanner;

public class SortMenu implements Screen
{
    private final Scanner scanner;
    private final Todos todos;
    private final Sorting sorting;

    private final Map<Integer, MenuCommand> commands;

    public SortMenu(Scanner scanner, Todos todos)
    {
        this.todos = todos;
        this.scanner = scanner;
        this.sorting = new Sorting(todos);

        commands = Map.of(
                1, new ActionCommand(() -> sorting.changeSorting(1), this),
                2, new ActionCommand(() -> sorting.changeSorting(2), this),
                3, new ActionCommand(() -> sorting.changeSorting(3), this),
                4, new ActionCommand(() -> sorting.changeSorting(4), this),
                5, new SwitchScreenCommand(() -> new TasksMenu(scanner, todos))
        );
    }

    private String getLabel()
    {
        return
                "======== SORTING ========                  Current: " + todos.getCurrentSort() + "\n" +
                "1. By todo and newest\n" +
                "2. By todo and older\n" +
                "3. By newest\n" +
                "4. By older\n\n" +
                "5. Back\n" +
                "=========================";
    }

    @Override
    public void draw()
    {
        System.out.println(getLabel());
    }

    @Override
    public Screen interact()
    {
        int choice = ConsoleInput.readInteger(scanner, "CHOICE", commands.size());

        return commands.get(choice).execute();
    }
}

