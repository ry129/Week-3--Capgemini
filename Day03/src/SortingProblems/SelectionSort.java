package SortingProblems;

public class SelectionSort {
    public static void sortExamScores(int[] examScores) {
        int n=examScores.length;
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (examScores[j] < examScores[min_index]) {
                    min_index = j;
                }
            }
            int temp = examScores[i];
            examScores[i] = examScores[min_index];
            examScores[min_index] = temp;
        }
    }
    public static void printExamScores(int[] examScores) {
        for (int i = 0; i < examScores.length; i++) {
            System.out.print(examScores[i] + " ");
        }
    }
    public static void main(String[] args) {
        int examScores[]={90,50,60,77,89,96};
        sortExamScores(examScores);
        System.out.println("\nSorted exam scores");
        printExamScores(examScores);
    }
}
