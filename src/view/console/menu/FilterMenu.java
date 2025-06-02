package view.console.menu;

import filter.Filter;
import memory.Todos;
import view.console.commands.ActionCommand;
import view.console.commands.MenuCommand;
import view.console.commands.SwitchScreenCommand;
import view.console.components.ConsoleInput;
import view.console.components.Screen;

import java.util.Map;
import java.util.Scanner;

public class FilterMenu implements Screen
{
    private final Scanner scanner;
    private final Map<Integer, MenuCommand> commands;
    private final Filter filter;

    private final String label =
            "=========== FILTER ===========\n" +
                    "1. Set tags to apply filter\n" +
                    "2. Clear current filter\n\n" +
                    "3. back\n" +
                    "==============================";

    public FilterMenu(Scanner scanner, Todos todos)
    {
        this.scanner = scanner;

        filter = new Filter(todos);

        commands = Map.of(
                1, new ActionCommand(this::setTags, this),
                2, new ActionCommand(filter::clear, this),
                3, new SwitchScreenCommand(() -> new TasksMenu(scanner, todos))
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

    private void setTags()
    {
        filter.setTargetTags(ConsoleInput.getString(scanner, "Enter tags to filter by (comma-separated)"));
        filter.filtrate();
    }
}
