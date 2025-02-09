import CompareDifferentDataStructure.SearchinginDataStructure;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class SearchinginDataStructureTest {

    // Simple linear search in an array (O(N))
    private boolean linearSearch(int[] arr, int target) {
        for (int value : arr) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    // Search using a HashSet (O(1) on average)
    private boolean hashSetSearch(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : arr) {
            set.add(value);
        }
        return set.contains(target);
    }

    // Search using a TreeSet (O(log N))
    private boolean treeSetSearch(int[] arr, int target) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int value : arr) {
            set.add(value);
        }
        return set.contains(target);
    }

    @Test
    public void testSearchFound() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        // Verify that the target is found in each approach.
        assertTrue(linearSearch(data, target), "Linear search should find the target.");
        assertTrue(hashSetSearch(data, target), "HashSet search should find the target.");
        assertTrue(treeSetSearch(data, target), "TreeSet search should find the target.");
    }

    @Test
    public void testSearchNotFound() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 10;
        // Verify that the target is not found in any of the searches.
        assertFalse(linearSearch(data, target), "Linear search should not find the target.");
        assertFalse(hashSetSearch(data, target), "HashSet search should not find the target.");
        assertFalse(treeSetSearch(data, target), "TreeSet search should not find the target.");
    }
}
