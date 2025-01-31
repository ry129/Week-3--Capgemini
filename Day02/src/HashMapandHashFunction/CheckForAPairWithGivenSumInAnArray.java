package sampleproblemsforhashmapshashfunctions;

import java.util.HashMap;

public class CheckForAPairWithGivenSumInAnArray {

    // Function to check for a pair with a given target sum
    static int[] checkPair(int[] nums, int target){
        int[] ans = new int[2]; // To store the result pair
        HashMap<Integer,Integer> map = new HashMap<>(); // To store array elements as keys and their indices as values

        // Iterate through the array
        for(int i=0; i<nums.length; i++){
            // Check if the (target - current element) exists in the map
            Integer value = map.get(target - nums[i]);
            if(value == null){
                map.put(nums[i], i); // Add current element to map
            }else{
                // If a pair is found, store the pair in ans
                ans[0] = nums[i];
                ans[1] = nums[value];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int target = 8;
        int[] ans = checkPair(nums, target); // Get the pair with the given target sum


        System.out.println("["+ ans[0] + "," + ans[1] + "]");
    }
}
