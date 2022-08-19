package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class LeetCode1450 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1450 obj = new LeetCode1450();
        System.out.println(obj.busyStudent(new int[] { 1, 2, 3 }, new int[] { 3, 2, 7 }, 4));

    }

}
