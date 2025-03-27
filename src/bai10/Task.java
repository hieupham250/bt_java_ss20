package bai10;

import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private User assignedTo;
    private LocalDate dueDate;
    private boolean completed;

    public Task(int id, String title, User assignedTo, LocalDate dueDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public boolean isOverdue() {
        return !completed && dueDate.isBefore(LocalDate.of(2025, 3, 23));
    }

    public String toDisplayString() {
        return String.format("Task: %-20s | Due: %s | Completed: %s", title, dueDate, completed);
    }
}
