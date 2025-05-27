package view.console.draft;

import schemas.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskDraft
{
    private String text;
    private final ArrayList<String> tags = new ArrayList<>();

    public void setText(String text)
    {
        this.text = text;
    }

    public void addTag(String tag)
    {
        tags.add(tag);
    }

    public boolean isValid()
    {
        return text != null && !text.isBlank();
    }

    public Task toTask()
    {
        return new Task(true, LocalDateTime.now().withNano(0), text, new ArrayList<>(tags));
    }
}
