import java.util.Locale;
import java.util.Scanner;

//Time Complexity: O(n1*n2);
//Space Complexity: O(n1*n2);

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter String 1: ");
        String str1 = scanner.nextLine().toLowerCase(Locale.ROOT);
        System.out.print("Enter String 2: ");
        String str2 = scanner.nextLine().toLowerCase(Locale.ROOT);
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp = new int[n1+1][n2+1];

        dp[0][0] = 0;
        for(int i=1; i<=n1; i++) {
            dp[i][0] = i;
        }
        for(int i=1; i<=n2; i++) {
            dp[0][i] = i;
        }

        for(int x=1; x<=n1; x++) {
            for(int y=1; y<=n2; y++) {
                dp[x][y] = Math.min(Math.min(dp[x][y-1]+1, dp[x-1][y]+1),
                        dp[x-1][y-1] + ((str1.charAt(x-1)==str2.charAt(y-1)) ? 0 : 1));
            }
        }

        for(int x=0; x<=n1; x++) {
            for(int y=0; y<=n2; y++) {
                System.out.print(dp[x][y]+"  ");
            }
            System.out.println();
        }
        System.out.println("Minimum Edit Distance: " + dp[n1][n2]);

    }
}
