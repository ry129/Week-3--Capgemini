package sampleproblemsforstacksandqueues;


import java.util.Stack;

public class SortAStackUsingRecursion {

    // Function to insert an element in the correct position in a sorted stack
    static void sortedInsert(Stack<Integer> stack, int element) {
       // If stack is empty or element is greater than top, insert it
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Pop the top element and recursively insert the element
        int top = stack.pop();
        sortedInsert(stack, element);

        // Push the popped element back after inserting the current element
        stack.push(top);
    }

    // Function to recursively sort the stack
    static void sortStack(Stack<Integer> stack) {
        // If the stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Pop the top element and sort the remaining stack
        int element = stack.pop();
        sortStack(stack);

        // Insert the popped element back in the correct position
        sortedInsert(stack, element);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Pushing sample elements to the stack
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        // Sort the stack
        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
