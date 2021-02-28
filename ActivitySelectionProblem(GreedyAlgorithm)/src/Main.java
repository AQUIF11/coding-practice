import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of activities: ");
        int n = Integer.parseInt(scanner.nextLine());
        Activity[] activities = new Activity[n];
        String[] str;
        for(int i=0; i<n; i++) {
            System.out.print("Enter duration(start-time end-time) of activity " + (i+1) + ": ");
            str = scanner.nextLine().split(" ");
            activities[i] = new Activity(str[0], str[1], i+1);
        }

        Arrays.sort(activities, new Activity.SortByEndTime());
        List<Activity> selectedActivities = new ArrayList<Activity>();
        int i=0;
        int currentTime = 0;
        while(i<n) {
            if(currentTime <= activities[i].getStartTime()) {
                selectedActivities.add(activities[i]);
                currentTime = activities[i].getEndTime();
            }
            i++;
        }

        System.out.println("Max number of activities: " + selectedActivities.size());
        for(int j=0; j<selectedActivities.size(); j++) {
            System.out.print(selectedActivities.get(j) + "  ");
        }

        System.out.println();
    }
}
