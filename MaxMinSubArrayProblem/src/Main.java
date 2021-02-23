// Kadane's Algorithm

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        System.out.print("Enter the array: ");
        String[] str = scanner.nextLine().split(" ");
        for(String s : str) {
            list.add(Integer.valueOf(s));
        }
        System.out.println(maxSubArraySum(list));
        System.out.println(minSubArraySum(list));
        scanner.close();
    }
    public static int maxSubArraySum(List<Integer> l) {
        int sum = 0, best = 0;
        for(int i=0; i<l.size(); i++) {
            sum = Math.max(l.get(i), sum+l.get(i));
            best = Math.max(sum, best);
        }
        return best;
    }

    public static int minSubArraySum(List<Integer> l) {
        int sum = 0, best = 0;
        for(int i=0; i<l.size(); i++) {
            sum = Math.min(l.get(i), sum+l.get(i));
            best = Math.min(sum, best);
        }
        return best;
    }
}