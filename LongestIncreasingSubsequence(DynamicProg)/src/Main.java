import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the Array: ");
        String[] str = scanner.nextLine().split(" ");
        int[] arr = new int[str.length];
        for(int i=0; i<str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int n = arr.length;
        int[] length = new int[n];
        int maxIndex = 0;
        int maxLength = 1;

        for(int k=0; k<n; k++) {
            length[k] = 1;
            for(int i=0; i<k; i++) {
                if(arr[i] < arr[k]) {
                    length[k] = Math.max(length[k], length[i]+1);
                }
            }

            if(length[k] > maxLength) {
                maxLength = length[k];
                maxIndex = k;
            }
        }

//        for(int i=1; i<n; i++) {
//            if(length[i] > length[maxIndex]) {
//                maxIndex = i;
//            }
//        }

        System.out.println("Longest increasing subsequence length: " + length[maxIndex]);
        System.out.println("Longest increasing subsequence index: " + maxIndex);
    }
}
