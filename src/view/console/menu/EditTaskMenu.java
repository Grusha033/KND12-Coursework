package view.console.menu;

import memory.Todos;
import model.Task;
import view.console.commands.ActionCommand;
import view.console.commands.MenuCommand;
import view.console.commands.SwitchScreenCommand;
import view.console.components.ConsoleInput;
import view.console.components.Screen;
import view.console.draft.TaskEditor;

import java.util.Map;
import java.util.Scanner;

public class EditTaskMenu implements Screen
{
    private final Scanner scanner;
    private final Map<Integer, MenuCommand> commands;

    private final TaskEditor taskEditor;
    private final Task targetTask;
    private final Todos todos;

    private final String label;

    public EditTaskMenu(Scanner scanner, Todos todos, int targetId)
    {
        this.scanner = scanner;
        this.todos = todos;

        targetTask = todos.getTasks().get(targetId);
        taskEditor = new TaskEditor(targetTask);

        commands = Map.of(
                1, new ActionCommand(this::changeText, this),
                2, new SwitchScreenCommand(() -> new TagsMenu(scanner, todos, targetId)),
                3, new ActionCommand(taskEditor::markAsDone, this),
                4, new ActionCommand(this::delete, new TasksMenu(scanner, todos)),
                5, new SwitchScreenCommand(() -> new TasksMenu(scanner, todos))
        );

        this.label =
        "========= EDIT =========                 Now editing: " + targetId + "\n"+
        "1. Edit text\n" +
        "2. Change tags\n" +
        "3. Mark as done\n" +
        "4. Delete\n\n" +
        "5. Back\n" +
        "========================";
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

    private void changeText()
    {
        taskEditor.newText(ConsoleInput.getString(scanner, "Current text: " + targetTask.getValue()));
    }

    private void delete()
    {
        todos.remove(targetTask);
    }
}
