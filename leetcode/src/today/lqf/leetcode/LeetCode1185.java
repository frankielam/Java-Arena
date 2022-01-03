package today.lqf.leetcode;

import java.util.Calendar;

public class LeetCode1185 {
    
    public String dayOfTheWeek(int day, int month, int year) {
        String[] DAYS = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return DAYS[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public static void main(String[] args) {
        LeetCode1185 obj = new LeetCode1185();
        System.out.println(obj.dayOfTheWeek(31, 8, 2019));

    }

}
