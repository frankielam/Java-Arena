package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode539 {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            String[] th = time.split(":");
            int hour = Integer.parseInt(th[0]);
            int min = Integer.parseInt(th[1]);
            arr[i] = hour * 60 + min;
        }
        int min = 24 * 60 - arr[arr.length - 1] + arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[i-1] < min) {
                min = arr[i] - arr[i-1];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode539 obj = new LeetCode539();
        List<String> list = new ArrayList<>();
        list.add("00:00");
        list.add("23:29");
        list.add("00:10");
        int rst = obj.findMinDifference(list);
        System.out.println(rst);

    }

}
