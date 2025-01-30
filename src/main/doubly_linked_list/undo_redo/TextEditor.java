package main.doubly_linked_list.undo_redo;

class TextEditor {
    // Doubly Linked List Node
    class Node {
        String textState;  // State of the text
        Node prev;         // Previous state (for undo)
        Node next;         // Next state (for redo)

        Node(String textState) {
            this.textState = textState;
            this.prev = null;
            this.next = null;
        }
    }

    private Node current;       // Points to the current state
    private Node head;          // Points to the first state
    private Node tail;          // Points to the last state
    private int size;           // Size of the history
    private static final int MAX_HISTORY_SIZE = 10;

    // Constructor
    public TextEditor() {
        this.current = null;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add new text state at the end of the list
    public void addState(String textState) {
        Node newNode = new Node(textState);

        // If history size exceeds the limit, remove the oldest state
        if (size == MAX_HISTORY_SIZE) {
            removeOldestState();
        }

        if (current == null) {
            // If no states exist, this becomes both head and tail
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            // Add new state at the end (tail)
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = tail;
        }

        size++;
    }

    // Remove the oldest state from the list
    private void removeOldestState() {
        if (head == null) return;

        // Remove the head (oldest state)
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
    }

    // Undo functionality (revert to the previous state)
    public String undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            return current.textState;
        } else {
            return "No more undo available.";
        }
    }

    // Redo functionality (revert to the next state)
    public String redo() {
        if (current != null && current.next != null) {
            current = current.next;
            return current.textState;
        } else {
            return "No more redo available.";
        }
    }

    // Display the current state of the text
    public String getCurrentState() {
        return current != null ? current.textState : "No state available.";
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Simulate some actions
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World!!");
        editor.addState("Hello World!!!");

        System.out.println("Current State: " + editor.getCurrentState());

        System.out.println("Undo: " + editor.undo());
        System.out.println("Undo: " + editor.undo());

        System.out.println("Redo: " + editor.redo());
        System.out.println("Redo: " + editor.redo());

        editor.addState("New State After Redo");

        System.out.println("Current State: " + editor.getCurrentState());
    }
}
