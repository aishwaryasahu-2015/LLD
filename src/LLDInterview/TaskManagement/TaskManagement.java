package LLDInterview.TaskManagement;

import java.util.*;

public class TaskManagement {
    PriorityQueue<Task> taskHeap;
    Map<Integer, Task> taskMap;
    int tasksTillNow;
    List<User> users;

    public static void main(String args[]) {
        TaskManagement taskManagement = new TaskManagement();
        taskManagement.initialize();

        taskManagement.createUsers();
        taskManagement.createUsers();

        taskManagement.createTask(1, taskManagement.users.get(0));
        taskManagement.createTask(2, taskManagement.users.get(0));
        taskManagement.createTask(3, taskManagement.users.get(0));
        taskManagement.createTask(4, taskManagement.users.get(0));
        taskManagement.createTask(5, taskManagement.users.get(0));

        taskManagement.executeTask();

        taskManagement.updateTask(12, 12);
        taskManagement.updateTask(4, 12);


        taskManagement.deleteTask(4);
    }

    public void createUsers() {
        User user = new User();
        users.add(user);
    }

    public void initialize() {
        this.tasksTillNow = 0;
        this.taskMap = new HashMap<>();
        this.taskHeap = new PriorityQueue<>((a, b) -> b.priority - a.priority);
    }

    public void createTask(int priority, User user) {
        System.out.println("Create the");
        int taskId = tasksTillNow + 1;
        Task newTask = new Task(priority, taskId, user);
        taskMap.put(taskId, newTask);
        taskHeap.add(newTask);
    }

    public void updateTask(int taskId, int priority) {
        Task task = taskMap.getOrDefault(taskId, null);
        if (task == null) {
            System.out.println("Task with taskId: " + taskId + " doesn't exists");
            return;
        }
        task.priority = priority;
        taskMap.put(taskId, task);


        List<Task> tasks = new ArrayList<>();
        while (!taskHeap.isEmpty()) {
            Task curTask = taskHeap.poll();
            if (curTask.taskId == taskId) {
                curTask.priority = priority;
                tasks.add(curTask);
                break;
            }
            tasks.add(curTask);
        }

        taskHeap.addAll(tasks);
    }

    public void deleteTask(int taskId) {
        Task task = taskMap.getOrDefault(taskId, null);
        if (task == null) {
            System.out.println("Task with taskId: " + taskId + " doesn't exists");
            return;
        }

        taskMap.remove(taskId);

        List<Task> tasks = new ArrayList<>();
        while (!taskHeap.isEmpty()) {
            Task curTask = taskHeap.poll();
            if (curTask.taskId == taskId) {
                break;
            }
            tasks.add(curTask);
        }

        taskHeap.addAll(tasks);
    }

    public void executeTask() {
        System.out.println("Executing the task with highest priority:");
        if (taskHeap.isEmpty()) {
            System.out.println("No Task to execute");
            return;
        }

        Task task = taskHeap.poll();
        System.out.println("Task has taskId: " + task.taskId);
        System.out.println("Task has userId: " + task.user.userId);
    }
}
