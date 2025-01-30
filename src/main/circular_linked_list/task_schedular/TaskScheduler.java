package main.circular_linked_list.task_schedular;

public class TaskScheduler {
    private Task head = null;
    private Task tail = null;

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            tail.next = head; // Make it circular
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Update tail to point to the new head
        }
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            tail.next = head; // Make it circular
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; // Update tail to point to head
        }
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position <= 1 || head == null) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
        } else {
            Task current = head;
            int count = 1;
            while (count < position - 1 && current.next != head) {
                current = current.next;
                count++;
            }
            newTask.next = current.next;
            current.next = newTask;
            if (current == tail) {
                tail = newTask;
            }
        }
    }

    // Remove a task by main.circular_linked_list.task_schedular.Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task current = head;
        Task previous = tail;
        do {
            if (current.taskId == taskId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }
                System.out.println("main.circular_linked_list.task_schedular.Task with ID " + taskId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("main.circular_linked_list.task_schedular.Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next
    public void viewCurrentTaskAndMove() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current main.circular_linked_list.task_schedular.Task: ID=" + head.taskId + ", Name=" + head.taskName +
                ", Priority=" + head.priority + ", Due Date=" + head.dueDate);
        head = head.next; // Move to the next task
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task current = head;
        do {
            System.out.println("main.circular_linked_list.task_schedular.Task ID=" + current.taskId + ", Name=" + current.taskName +
                    ", Priority=" + current.priority + ", Due Date=" + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("main.circular_linked_list.task_schedular.Task Found: ID=" + current.taskId + ", Name=" + current.taskName +
                        ", Priority=" + current.priority + ", Due Date=" + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No task found with priority " + priority);
        }
    }
}
