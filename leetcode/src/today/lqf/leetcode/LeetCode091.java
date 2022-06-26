package today.lqf.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/JEj789/
 * DP 
 */
public class LeetCode091 {

    public int minCost(int[][] costs) {
        int[] arr = new int[3];
        for (int[] cost : costs) {
            int[] cur = new int[3];
            for (int j = 0; j < 3; j++) {
                cur[j] = cost[j] + Math.min(arr[(j + 1) % 3], arr[(j + 2) % 3]);
            }
            arr = cur;
        }
        return Arrays.stream(arr).min().getAsInt();
    }

    public static void main(String[] args) {
        LeetCode091 obj = new LeetCode091();
        System.out.println(obj.minCost(new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } }));
        System.out.println(obj.minCost(new int[][] { { 7, 6, 2 } }));
    }

}
