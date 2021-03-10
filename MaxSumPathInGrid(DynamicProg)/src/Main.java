import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] grid = {{3, 7, 9, 2, 7},
                        {9, 8, 3, 5, 5},
                        {1, 7, 9, 8, 5},
                        {3, 8, 6, 4, 10},
                        {6, 3, 9, 7, 8}};
        int m = grid.length;   // No of ROWS
        int n = grid[0].length;  // No of COLUMNS
        int[][] sum = new int[m+1][n+1];

//        FOR MIN SUM PATH
//        for(int i=0; i<=n; i++) {
//            sum[0][i] = Integer.MAX_VALUE;
//        }
//
//        for(int i=0; i<=m; i++) {
//            sum[i][0] = Integer.MAX_VALUE;
//        }
//
//        for(int x=1; x<=m; x++) {
//            for(int y=1; y<=n; y++) {
//                if(x==1 && y==1) {
//                    sum[y][x] = grid[y-1][x-1];
//                } else {
//                    sum[y][x] = Math.min(sum[y][x-1], sum[y-1][x]) + grid[y-1][x-1];
//                }
//            }
//        }

        for(int x=1; x<=m; x++) {
            for(int y=1; y<=n; y++) {
                sum[y][x] = Math.max(sum[y][x-1], sum[y-1][x]) + grid[y-1][x-1];
            }
        }

        System.out.println("Max sum path value: " + sum[n][m]);

//        System.out.println("Min sum path value: " + sum[n][m]);

    }
}
