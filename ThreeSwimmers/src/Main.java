import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        long p, a, b, c;
        for(int i=0; i<n; i++) {
            p = scanner.nextLong();
            a = scanner.nextLong();
            b = scanner.nextLong();
            c = scanner.nextLong();

            System.out.println((long)(Math.min(Math.ceil((double)p/a)*a, Math.min(Math.ceil((double)p/b)*b, Math.ceil((double)p/c)*c)) - p));
        }
    }
}