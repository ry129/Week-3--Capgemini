package sampleproblemsforstacksandqueues;

import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Function to enqueue a value
    void enQueue(int value){
        // Transfer elements from s1 to s2
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(value); // Push the new value

        // Transfer elements back to s1
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    // Function to dequeue a value
    int deQueue(){
        if(s1.isEmpty()){
            System.out.println("Stack is empty... ");
            return -1; // Return -1 if empty
        }
        int value = s1.peek(); // Get the front element
        s1.pop(); // Remove the front element
        return value; // Return the front element
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
