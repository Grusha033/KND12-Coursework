package view.console.menu;

import model.Todos;
import schemas.Task;
import view.console.commands.ActionCommand;
import view.console.commands.MenuCommand;
import view.console.commands.SwitchScreenCommand;
import view.console.components.ConsoleInput;
import view.console.components.Screen;
import view.console.draft.TaskEditor;

import java.util.Map;
import java.util.Scanner;

public class TagsMenu implements Screen
{
    private final Scanner scanner;
    private final TaskEditor taskEditor;
    private final Todos todos;
    private final Task currentTask;

    private final Map<Integer, MenuCommand> commands;

    private final String label =
            "========== TAGS ==========\n" +
                    "1. add tag\n" +
                    "2. remove tag\n\n" +
                    "3. Exit\n" +
                    "==========================";

    public TagsMenu(Scanner scanner, Todos todos, int targetId)
    {
        this.scanner = scanner;
        this.todos = todos;
        this.currentTask = todos.getTasks().get(targetId);
        this.taskEditor = new TaskEditor(currentTask);

        commands = Map.of(
                1, new ActionCommand(this::addTag, this),
                2, new ActionCommand(this::removeTag, this),
                3, new SwitchScreenCommand(() -> new EditTaskMenu(scanner, todos, targetId))
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

    private void addTag()
    {
        String input = ConsoleInput.getString(scanner, "Enter tag(s) to add (use commas to separate multiple tags)");

        taskEditor.addTag(input);
    }

    private void removeTag()
    {
        String prompt = "Enter tag(s) to remove (use commas to separate multiple tags, or write -all to remove all)\nCurrent tags " + currentTask.getTags();
        String input = ConsoleInput.getString(scanner, prompt);

        taskEditor.removeTag(input);
    }
}
