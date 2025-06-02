package sorting;

import model.Task;

import java.util.Comparator;

public class SortByActiveAndNewest implements Comparator<Task>
{
    @Override
    public int compare(Task fTask, Task sTask)
    {
        int activeCompare = Boolean.compare(sTask.getIsActive(), fTask.getIsActive());
        if (activeCompare != 0)
        {
            return activeCompare;
        }

        return sTask.getCreatedAt().compareTo(fTask.getCreatedAt());
    }

    public String toString()
    {
        return "todo and newest";
    }
}
