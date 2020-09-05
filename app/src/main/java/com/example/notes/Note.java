package com.example.notes;

public class Note
{
    private String title;
    private String description;
    private String dayOfWeek;
    private int priority;

    public Note(String title, String description, String dayOfWeek, int priority)
    {
        this.title = title;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getDescription()
    {
        return this.description;
    }

    public String getDayOfWeek()
    {
        return this.dayOfWeek;
    }

    public int getPriority()
    {
        return this.priority;
    }
}
