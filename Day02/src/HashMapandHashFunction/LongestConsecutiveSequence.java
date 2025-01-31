package sampleproblemsforhashmapshashfunctions;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    // Function to find the longest consecutive sequence
    static int longestConsecutiveSeq(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        // Add elements to the set
        for(int num : nums){
            set.add(num);
        }

        int longest = 0;

        // Check for the longest streak starting from each element
        for(int num: nums){
            int currentNum = num;
            int currentStreak = 1;

            // If it's the start of a sequence
            if(!set.contains(currentNum - 1)){
                // Count the streak length
                while(set.contains(currentNum + 1)){
                    currentNum++;
                    currentStreak++;
                }
            }
            longest = Math.max(longest, currentStreak); // Update longest streak
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,3,4,8};
        int ans = longestConsecutiveSeq(nums); // Get the longest sequence length

        // Output the result
        System.out.println("Longest Consecutive Sequence is: "+ ans);
    }
}
