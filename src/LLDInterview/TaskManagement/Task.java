package LLDInterview.TaskManagement;

public class Task {
    int taskId;
    int priority;
    User user;

    public Task(int priority, int taskId, User user) {
        this.taskId = taskId;
        this.priority = priority;
        this.user = user;
    }
}
