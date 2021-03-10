import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the coin set: ");
        String[] str = scanner.nextLine().split(" ");
        int[] coinSet = new int[str.length];
        for(int i=0; i<str.length; i++) {
            coinSet[i] = Integer.parseInt(str[i]);
        }

        System.out.print("Enter the value of sum: ");
        int n = scanner.nextInt();

        int[] count = new int[n+1];

        count[0] = 1;
        for(int i=1; i<=n; i++) {
            for(int c : coinSet) {
                if((i-c)>=0) {
                    count[i] += count[i-c];
                }
            }
        }

        System.out.println("Total Solutions: " + count[n]);

    }
}
