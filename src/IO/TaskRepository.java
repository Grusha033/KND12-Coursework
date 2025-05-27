package IO;

import schemas.Task;

import java.util.ArrayList;

public interface TaskRepository
{
    public ArrayList<Task> loadTasks();

    public void saveTasks(ArrayList<Task> tasks);
}
