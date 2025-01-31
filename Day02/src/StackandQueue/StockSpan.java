package sampleproblemsforstacksandqueues;

import java.util.Stack;

public class StockSpan {

    // Function to calculate stock span
    static int[] calculateSpan(int[] price){
        Stack<Integer> st = new Stack<>();
        int n = price.length;
        int[] span = new int[n];

        // Calculate span for each day
        for(int i = 0; i < n; i++){
            // Pop elements from stack while the current price is higher
            while(!st.isEmpty() && price[st.peek()] <= price[i]){
                st.pop();
            }
            // If stack is empty, span is the whole range from the start
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek(); // Calculate the span
            }

            // Push current index onto the stack
            st.push(i);
        }
        return span; // Return the span array
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices); // Get the stock span

        // Print the stock spans
        System.out.print("Stock Spans: ");
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
