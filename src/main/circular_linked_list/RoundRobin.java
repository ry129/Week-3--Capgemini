import java.util.Scanner;

class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;

    // Add a process to the end of the circular linked list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
            tail = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
        System.out.println("Added Process ID: " + processId + ", Burst Time: " + burstTime + ", Priority: " + priority);
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            return;
        }

        Process current = head, prev = tail;

        do {
            if (current.processId == processId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Simulate round-robin scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        System.out.println("\nStarting Round Robin Scheduling with Time Quantum: " + timeQuantum);

        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int processCount = 0;

        // Count the total number of processes
        Process current = head;
        do {
            processCount++;
            current = current.next;
        } while (current != head);

        while (head != null) {
            current = head;

            do {
                if (current.burstTime > 0) {
                    int executedTime = Math.min(current.burstTime, timeQuantum);
                    System.out.println("Executing Process ID: " + current.processId + " for " + executedTime + " units.");
                    current.burstTime -= executedTime;

                    if (current.burstTime == 0) {
                        System.out.println("Process ID " + current.processId + " completed.");
                        totalTurnAroundTime += executedTime + totalWaitingTime;
                        removeProcess(current.processId);
                        processCount--;
                        if (processCount == 0) break;
                             }
                    else {
                        totalWaitingTime += executedTime;
                    }
                }

                current = current.next;
            } while (current != head);

            displayProcesses();
        }

        // Calculate and display average waiting time and turnaround time
        System.out.println("\nAll processes completed.");
        double avgWaitingTime = (double) totalWaitingTime / processCount;
        double avgTurnAroundTime = (double) totalTurnAroundTime / processCount;
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnAroundTime);
    }

    // Display the list of processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes left in the queue.");
            return;
        }

        System.out.println("Processes in the circular queue:");
        Process current = head;
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }
}

public class RoundRobin{
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        Scanner scanner = new Scanner(System.in);

        // Example Usage
        System.out.println("Enter the number of processes to add:");
        int numProcesses = scanner.nextInt();

        for (int i = 0; i < numProcesses; i++) {
            System.out.println("Enter Process ID, Burst Time, and Priority:");
            int processId = scanner.nextInt();
            int burstTime = scanner.nextInt();
            int priority = scanner.nextInt();
            scheduler.addProcess(processId, burstTime, priority);
        }

        System.out.println("Enter the time quantum for Round Robin Scheduling:");
        int timeQuantum = scanner.nextInt();

        scheduler.simulateRoundRobin(timeQuantum);
    }
}