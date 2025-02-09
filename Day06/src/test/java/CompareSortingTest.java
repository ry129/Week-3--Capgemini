import SortingLargeDataEfficiently.CompareSorting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Arrays;

// If SortingComparison is in a package, import it like:
// import com.example.sorting.SortingComparison;

public class CompareSortingTest {

    @Test
    public void testBubbleSort() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);  // Use Java's built-in sort to get the expected sorted array.

        // Call bubbleSort from SortingComparison
        CompareSorting.bubbleSort(arr);

        // Verify that the array is correctly sorted
        assertArrayEquals(expected, arr, "Bubble Sort should correctly sort the array.");
    }

    @Test
    public void testMergeSort() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);  // Expected sorted order

        // Call mergeSort from SortingComparison
        CompareSorting.mergeSort(arr);

        // Verify that the array is correctly sorted
        assertArrayEquals(expected, arr, "Merge Sort should correctly sort the array.");
    }

    @Test
    public void testQuickSort() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);  // Expected sorted order

        // Call quickSort from SortingComparison.
        // Ensure you pass the correct low (0) and high (arr.length - 1) indices.
        CompareSorting.quickSort(arr, 0, arr.length - 1);

        // Verify that the array is correctly sorted
        assertArrayEquals(expected, arr, "Quick Sort should correctly sort the array.");
    }
}


