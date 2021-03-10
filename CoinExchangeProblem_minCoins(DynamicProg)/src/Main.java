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

        int[] values = new int[n+1];
        int[] first = new int[n+1];

        values[0] = 0;
        for(int i=1; i<=n; i++) {
            values[i] = Integer.MAX_VALUE;
            for(int c : coinSet) {
                if((i-c)>=0 && (values[i-c]+1) < values[i]) {
                    values[i] = values[i-c] + 1;
                    first[i] = c;
                }
            }
        }

        System.out.println("Min number of coins required to form sum: " + values[n]);
        System.out.println("Solution:");
        while(n>0) {
            System.out.print(first[n] + "  ");
            n -= first[n];
        }

    }
}
