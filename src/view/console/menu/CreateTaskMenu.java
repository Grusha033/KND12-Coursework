package view.console.menu;

import memory.Todos;
import view.console.commands.ActionCommand;
import view.console.commands.MenuCommand;
import view.console.commands.SwitchScreenCommand;
import view.console.draft.TaskDraft;
import view.console.components.ConsoleInput;
import view.console.components.Screen;

import java.util.Map;
import java.util.Scanner;

public class CreateTaskMenu implements Screen
{
    private final Scanner scanner;
    private final Todos todos;

    private final Map<Integer, MenuCommand> commands;
    private final TaskDraft taskDraft = new TaskDraft();

    private final String label =
            "======== NEW TASK ========\n" +
            "1. Set text\n" +
            "2. Add tag\n\n" +
            "3. Confirm\n" +
            "4. Back\n" +
            "==========================";

    public CreateTaskMenu(Scanner scanner, Todos todos)
    {
        this.scanner = scanner;
        this.todos = todos;
        commands = Map.of(
                1, new ActionCommand(this::setText, this),
                2, new ActionCommand(this::addTag, this),
                3, new ActionCommand(this::confirm, new TasksMenu(scanner, todos)),
                4, new SwitchScreenCommand(() -> new TasksMenu(scanner, todos))
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

    private void setText()
    {
        taskDraft.setText(ConsoleInput.getString(scanner, "Your task"));
    }

    private void addTag()
    {
        taskDraft.addTag(ConsoleInput.getString(scanner, "Tag"));
    }

    private void confirm()
    {
        todos.addNewTask(taskDraft.toTask());
    }
}
