package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/distance-between-bus-stops/
 */
public class LeetCode1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int d1 = 0, d2 = 0;
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        for (int i = 0; i < distance.length; i++) {
            if (i < start || i >= destination) {
                d1 += distance[i];
            } else {
                d2 += distance[i];
            }
        }
        return Math.min(d1, d2);
    }

    public static void main(String[] args) {
        LeetCode1184 obj = new LeetCode1184();
        System.out.println(obj.distanceBetweenBusStops(new int[] { 7, 10, 1, 12, 11, 14, 5, 0 }, 4, 0));
    }

}
