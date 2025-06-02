package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Task
{
    private String value;
    private LocalDateTime createdAt;
    private ArrayList<String> tags;
    private boolean isActive;
    private boolean drawable = true;

    public Task(boolean isActive, LocalDateTime createdAt, String value, ArrayList<String> tags)

    {
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.value = value;

        this.tags = tags;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public String getFormattedCreatedAt()
    {
        return createdAt.format(DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss"));
    }

    public Boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean value)
    {
        this.isActive = value;
    }

    public ArrayList<String> getTags()
    {
        return tags;
    }

    public void setDrawable(boolean drawable)
    {
        this.drawable = drawable;
    }

    public boolean getDrawable()
    {
        return drawable;
    }

    @Override
    public String toString()
    {
        return "Task{" +
                "value='" + value + '\'' +
                ", createdAt=" + getFormattedCreatedAt() +
                ", tags=" + tags.toString() +
                ", isActive=" + isActive +
                '}';
    }
}