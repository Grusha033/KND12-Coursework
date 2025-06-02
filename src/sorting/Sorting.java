package sorting;

import memory.Todos;

import java.util.HashMap;
import java.util.Map;

public class Sorting
{
    private final Todos todos;

    private final Map<Integer, SortType> sortMap = new HashMap<>();

    public Sorting(Todos todos)
    {
        this.todos = todos;

        sortMap.put(1, SortType.ACTIVE_AND_NEWEST);
        sortMap.put(2, SortType.ACTIVE_AND_OLDEST);
        sortMap.put(3, SortType.NEWEST);
        sortMap.put(4, SortType.OLDEST);
    }

    public void changeSorting(int value)
    {
        SortType sortType = sortMap.get(value);
        if (sortType != null)
        {
            todos.sort(sortType.getComparator());
        }
        else
        {
            System.out.println("Unknown sort option: " + value);
        }
    }

    public Map<Integer, SortType> getSortMap()
    {
        return sortMap;
    }
}
