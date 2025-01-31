package sampleproblemsforstacksandqueues;

public class CircularTour {

    // Function to find the starting pump for the circular tour
    static int findStartingPump(int[] petrol, int[] distance){
        int n = petrol.length;
        int deficit = 0;
        int balance = 0;
        int start = 0;

        // Check each pump
        for(int i = 0; i < n; i++){
            balance += petrol[i] - distance[i];
            if(balance < 0){
                deficit += balance;
                start = i + 1;
                balance = 0;
            }
        }

        // If total balance is non-negative, return start pump
        if(deficit + balance >= 0){
            return start;
        } else {
            return -1; // No valid start
        }
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int ans = findStartingPump(petrol, distance); // Find the starting pump
        System.out.println("Starting pump is: " + ans); // Output result
    }
}
