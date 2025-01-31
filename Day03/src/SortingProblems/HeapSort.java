package SortingProblems;


class HeapSort {
        // Function to heapify a subtree rooted at index i
        public static void heapify(double[] salaries, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // Left child index
            int right = 2 * i + 2; // Right child index

            // If left child is larger than root
            if (left < n && salaries[left] > salaries[largest])
                largest = left;

            // If right child is larger than largest so far
            if (right < n && salaries[right] > salaries[largest])
                largest = right;

            // If largest is not root, swap and continue heapifying
            if (largest != i) {
                double temp = salaries[i];
                salaries[i] = salaries[largest];
                salaries[largest] = temp;

                // Recursively heapify the affected subtree
                heapify(salaries, n, largest);
            }
        }

        // Heap Sort function
        public static void heapSort(double[] salaries) {
            int n = salaries.length;

            // Build a max heap
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(salaries, n, i);
            }

            // Extract elements from heap one by one
            for (int i = n - 1; i > 0; i--) {
                // Move current root to end
                double temp = salaries[0];
                salaries[0] = salaries[i];
                salaries[i] = temp;

                // Heapify the reduced heap
                heapify(salaries, i, 0);
            }
        }

        // Function to print the array
        public static void printArray(double[] salaries) {
            for (double salary : salaries) {
                System.out.print(salary + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            double[] salaries = {55000, 42000, 75000, 60000, 50000};
            System.out.println("Original Salary Demands:");
            printArray(salaries);

            heapSort(salaries);

            System.out.println("Sorted Salary Demands:");
            printArray(salaries);
        }
    }


