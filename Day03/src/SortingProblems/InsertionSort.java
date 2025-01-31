package SortingProblems;

public class InsertionSort {
    public static void sortEmployeeID(int  EmployeeId[]){
        for (int i = 1; i <EmployeeId.length; i++) {
            int key = EmployeeId[i];
            int j = i - 1;
            while (j >= 0 && EmployeeId[j] > key) {
                EmployeeId[j+1] = EmployeeId[j];
                j--;
            }
            EmployeeId[j+1] = key;
        }
    }
    public static void printArray(int EmployeeId[]){
        for (int i = 0; i < EmployeeId.length; i++) {
            System.out.print(EmployeeId[i] + " ");
        }
    }
    public static void main(String[] args) {
        int EmployeeId[] = {123,104,344,101,202};
        sortEmployeeID(EmployeeId);
        printArray(EmployeeId);
    }
}
