import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> minChange = new ArrayList<Integer>();
        System.out.print("Enter the coin set: ");
        String[] str = scanner.nextLine().split(" ");
        System.out.print("Enter the target money amount: ");
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] coinSet = new Integer[str.length];
        for(int i=0; i<str.length; i++) {
            coinSet[i] = Integer.valueOf(str[i]);
        }
//        for(Integer i : coinSet) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
        Arrays.sort(coinSet, Collections.reverseOrder());
        int i = 0;
        while(n>0) {
            while(n>=coinSet[i]) {
                n -= coinSet[i];
                minChange.add(coinSet[i]);
            }
            i++;
        }
        System.out.println("Min Coins Needed: " + minChange.size());
        System.out.println("Change: " + minChange);
    }
}
