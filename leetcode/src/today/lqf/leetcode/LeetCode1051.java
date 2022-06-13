package today.lqf.leetcode;

import java.util.Arrays;

public class LeetCode1051 {

    public int heightChecker(int[] heights) {
        int[] arr = new int[heights.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heights[i];
        }
        Arrays.sort(heights);
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != heights[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode1051 obj = new LeetCode1051();
        System.out.println(obj.heightChecker(new int[] { 1, 1, 4, 2, 1, 3 }));
        System.out.println(obj.heightChecker(new int[] { 5, 1, 2, 3, 4 }));

    }

}
