package sorting;

import model.Task;

import java.util.Comparator;

public class SortByDataOlder implements Comparator<Task>
{
    @Override
    public int compare(Task fTask, Task sTask)
    {
        return fTask.getCreatedAt().compareTo(sTask.getCreatedAt());
    }

    public String toString()
    {
        return "Older";
    }
}
