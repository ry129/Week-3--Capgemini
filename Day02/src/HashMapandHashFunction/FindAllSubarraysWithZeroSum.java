package sampleproblemsforhashmapshashfunctions;

import java.util.*;

class FindAllSubarraysWithZeroSum {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // Store sum 0 at index -1 to handle subarrays starting from index 0
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Calculate cumulative sum

            // If sum repeats, zero-sum subarrays exist
            if (sumMap.containsKey(sum)) {
                for (int startIdx : sumMap.get(sum)) {
                    result.add(Arrays.copyOfRange(arr, startIdx + 1, i + 1));
                }
            }

            // Store sum with its index
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-sum subarrays:");
        for (int[] subarray : subarrays) {
            System.out.println(Arrays.toString(subarray));
        }
    }
}
