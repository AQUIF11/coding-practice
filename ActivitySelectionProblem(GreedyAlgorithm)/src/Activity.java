import java.util.Comparator;

public class Activity {
    private int startTime;
    private int endTime;
    private int id;

    public Activity(String startTime, String endTime, int id) {
        this.startTime = Integer.parseInt(startTime);
        this.endTime = Integer.parseInt(endTime);
        this.id = id;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    static class SortByEndTime implements Comparator<Activity> {
        public int compare(Activity a, Activity b) {
            return a.endTime - b.endTime;
        }
    }

    @Override
    public String toString() {
        return "{" + id + " " +
                "(" + startTime +
                ", " + endTime +
                ')' + "}";
    }
}
