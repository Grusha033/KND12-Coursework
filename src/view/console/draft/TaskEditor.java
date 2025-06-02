package view.console.draft;

import model.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskEditor
{
    private final Task task;

    public TaskEditor(Task task)
    {
        this.task = task;
    }

    public void newText(String newText)
    {
        task.setValue(newText);
    }

    public void addTag(String tagInput)
    {
        for (String tag : parseTags(tagInput))
        {
            task.getTags().add(tag);
        }
    }

    public void removeTag(String tagInput)
    {
        String removeAllPrompt = "-all";

        ArrayList<String> currentTags = task.getTags();

        if (removeAllPrompt.equals(tagInput))
        {
            currentTags.clear();
            return;
        }

        for (String tag : parseTags(tagInput))
        {
            currentTags.remove(tag);
        }
    }

    public void markAsDone()
    {
        task.setIsActive(!task.getIsActive());
    }

    private List<String> parseTags(String input)
    {
        if (input == null || input.isBlank()) return List.of();
        return Arrays.stream(input.split("\\s*,\\s*"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }
}
