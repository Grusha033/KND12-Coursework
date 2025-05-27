package sorting;

import schemas.Task;

import java.util.Comparator;

public enum SortType
{
    ACTIVE_AND_NEWEST(new SortByActiveAndNewest()),
    ACTIVE_AND_OLDEST(new SortByActiveAndOlder()),
    NEWEST(new SortByDataNewest()),
    OLDEST(new SortByDataOlder());

    private final Comparator<Task> comparator;

    SortType(Comparator<Task> comparator)
    {
        this.comparator = comparator;
    }

    public Comparator<Task> getComparator()
    {
        return comparator;
    }
}
