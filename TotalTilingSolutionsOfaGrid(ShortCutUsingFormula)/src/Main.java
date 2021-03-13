import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the number of rows in grid: ");
        int m = scanner.nextInt();
        System.out.print("Enter the number of columns in grid: ");
        int n = scanner.nextInt();

        double count = 1;
        double const1 = Math.PI/(n+1);
        double const2 = Math.PI/(m+1);

        for(int x=1; x<=Math.ceil(((double)m)/2); x++) {
            for(int y=1; y<=Math.ceil(((double)n)/2); y++) {
                count *= 4*(Math.pow(Math.cos(const1*y), 2) + Math.pow(Math.cos(const2*x), 2));
            }
        }

        System.out.println("Total tiling combinations: " + /*(int)*/count);
    }
}
