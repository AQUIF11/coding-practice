package academy.learnprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the array 1: ");
        String[] str = scanner.nextLine().split(" ");
        int[] a1 = new int[str.length];
        for(int i=0; i<str.length-1; i++) {
            a1[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(a1);

        System.out.print("Enter the array 2: ");
        str = scanner.nextLine().split(" ");
        int[] a2 = new int[str.length];
        for(int i=0; i<str.length-1; i++) {
            a2[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(a2);

        int i=0, j=0, common=0;
        while(i<a1.length && j<a2.length) {
            if(a1[i] == a2[j]) {
                i++; j++; common++;
            } else if(a1[i] < a2[j]) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println("Number of common elements: " + common);
    }
}
