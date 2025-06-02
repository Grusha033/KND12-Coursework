package filter;

import memory.Todos;
import model.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filter
{
    private final List<Task> tasks;
    private String[] targetTags;

    public Filter(Todos todos)
    {
        this.tasks = todos != null ? todos.getTasks() : new ArrayList<>();
    }

    public void setTargetTags(String tagsCsv)
    {
        if (tagsCsv != null && !tagsCsv.trim().isEmpty())
        {
            this.targetTags = Arrays.stream(tagsCsv.split(","))
                    .map(String::trim)
                    .filter(tag -> !tag.isEmpty())
                    .toArray(String[]::new);
        } else
        {
            this.targetTags = new String[0];
        }
    }

    public void filtrate()
    {
        for (Task task : tasks)
        {
            boolean matches = false;

            for (String tag : targetTags)
            {
                if (task.getTags() != null && task.getTags().contains(tag))
                {
                    matches = true;
                    break;
                }
            }

            task.setDrawable(matches);
        }
    }

    public void clear()
    {
        for (Task task : tasks)
        {
            task.setDrawable(true);
        }
    }
}
