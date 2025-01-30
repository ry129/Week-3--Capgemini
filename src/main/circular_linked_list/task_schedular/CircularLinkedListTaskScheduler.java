package main.circular_linked_list.task_schedular;


// Main Class to test the main.circular_linked_list.task_schedular.Task Scheduler
public class CircularLinkedListTaskScheduler {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTaskAtEnd(1, "main.circular_linked_list.task_schedular.Task A", 3, "2025-01-30");
        scheduler.addTaskAtEnd(2, "main.circular_linked_list.task_schedular.Task B", 2, "2025-01-31");
        scheduler.addTaskAtBeginning(3, "main.circular_linked_list.task_schedular.Task C", 1, "2025-02-01");
        scheduler.addTaskAtPosition(2, 4, "main.circular_linked_list.task_schedular.Task D", 4, "2025-02-05");

        System.out.println("\nAll Tasks:");
        scheduler.displayAllTasks();

        System.out.println("\nView Current main.circular_linked_list.task_schedular.Task and Move:");
        scheduler.viewCurrentTaskAndMove();

        System.out.println("\nAll Tasks After Moving Current:");
        scheduler.displayAllTasks();

        System.out.println("\nSearch for main.circular_linked_list.task_schedular.Task with Priority 2:");
        scheduler.searchTaskByPriority(2);

        System.out.println("\nRemove main.circular_linked_list.task_schedular.Task with ID 2:");
        scheduler.removeTaskById(2);

        System.out.println("\nAll Tasks After Removal:");
        scheduler.displayAllTasks();
    }
}
