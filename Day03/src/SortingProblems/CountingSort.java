package SortingProblems;



    public class CountingSort {
        public static void countingSort(int[] ages, int minAge, int maxAge) {
            int range = maxAge - minAge + 1; // Range of values (10 to 18 → 9 values)
            int[] count = new int[range]; // Count array
            int[] output = new int[ages.length]; // Output array

            // Step 1: Count occurrences of each age
            for (int age : ages) {
                count[age - minAge]++;
            }

            // Step 2: Compute cumulative frequency
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            // Step 3: Build output array
            for (int i = ages.length - 1; i >= 0; i--) {
                output[count[ages[i] - minAge] - 1] = ages[i];
                count[ages[i] - minAge]--; // Decrease count after placing the element
            }

            // Step 4: Copy sorted elements back to original array
            System.arraycopy(output, 0, ages, 0, ages.length);
        }

        // Function to print the array
        public static void printArray(int[] ages) {
            for (int age : ages) {
                System.out.print(age + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int[] studentAges = {12, 14, 11, 15, 13, 12, 16, 18, 17, 12, 15, 14};
            System.out.println("Original Ages:");
            printArray(studentAges);

            countingSort(studentAges, 10, 18);

            System.out.println("Sorted Ages:");
            printArray(studentAges);
        }
    }


