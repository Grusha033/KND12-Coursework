package model;

import schemas.Task;
import sorting.SortByDataNewest;
import sorting.SortType;
import sorting.Sorting;

import java.util.ArrayList;
import java.util.Comparator;

public class Todos
{
    private final ArrayList<Task> todos;

    private Comparator<Task> currentSort;

    public Todos(ArrayList<Task> todos)
    {
        this.todos = todos;

        sort(SortType.NEWEST.getComparator());
    }

    public ArrayList<Task> getTasks()
    {
        return todos;
    }

    public void addNewTask(Task task)
    {
        todos.add(task);
        sort(currentSort);
    }

    public void sort(Comparator<Task> comparator)
    {
        todos.sort(comparator);
        currentSort = comparator;
    }

    public void remove(Task task)
    {
        todos.remove(task);
    }

    public Comparator<Task> getCurrentSort()
    {
        return currentSort;
    }
}