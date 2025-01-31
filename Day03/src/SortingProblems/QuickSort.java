package SortingProblems;



 class QuickSort {
    // Partition function to place the pivot in the correct position
    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Choosing last element as pivot
        int i = low - 1; // Index for smaller elements

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap pivot to correct position
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // Return partition index
    }

    // Quick Sort function
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(prices, low, high); // Get pivot position

            quickSort(prices, low, partitionIndex - 1);  // Sort left part
            quickSort(prices, partitionIndex + 1, high); // Sort right part
        }
    }

    // Function to print the array
    public static void printArray(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double[] productPrices = {499.99, 250.50, 799.75, 150.00, 350.00};
        System.out.println("Original Prices:");
        printArray(productPrices);

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Prices:");
        printArray(productPrices);
    }
}
