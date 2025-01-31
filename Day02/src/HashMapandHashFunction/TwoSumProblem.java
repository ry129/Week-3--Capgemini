package sampleproblemsforhashmapshashfunctions;

import java.util.HashMap;

public class TwoSumProblem {

    // Function to find indices of two numbers that add up to the target
    static int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];

        // Iterate through the array
        for(int i=0; i<nums.length; i++){
            Integer value = map.get(target - nums[i]); // Check if exists
            if(value == null){
                map.put(nums[i], i); // Store current number and its index
            }else{
                ans[0] = i; // First index of pair
                ans[1] = value; // Second index of pair
            }
        }
        return ans; // Return the result pair
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 8;

        int[] ans = twoSum(nums, target); // Get the indices of the pair
        System.out.println("["+ans[0]+","+ ans[1]+"]");
    }
}
