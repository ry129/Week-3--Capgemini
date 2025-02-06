package main;

import java.util.Scanner;

public class ReverseString {
    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str); // Create a StringBuilder object
        return sb.reverse().toString(); // Reverse and convert back to string
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        String reversed = reverse(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}
