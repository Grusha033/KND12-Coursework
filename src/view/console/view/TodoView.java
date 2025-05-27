package view.console.view;

import model.Todos;
import schemas.Task;

import java.util.ArrayList;

public class TodoView
{
    private final Todos todos;

    public TodoView(Todos todos)
    {
        this.todos = todos;
    }

    public void show()
    {
        String borders = "=".repeat(500);
        ArrayList<Task> tasks = todos.getTasks();
        int size = tasks.size();

        System.out.println(borders);

        for (int i = 0; i < size; i++)
        {
            Task task = tasks.get(i);

            if (task.getDrawable())
            {
                System.out.printf("%s | %s | %s | %s | %s\n",
                        i, task.getFormattedCreatedAt(), task.getIsActive() ? "TODO" : "DONE", task.getValue(), task.getTags().toString());
            }
        }

        System.out.println(borders + "\n\n\n");
    }
}
