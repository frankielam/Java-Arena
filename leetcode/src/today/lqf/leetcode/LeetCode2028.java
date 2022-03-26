package today.lqf.leetcode;

import java.util.Arrays;

/**
 * 
 * https://leetcode-cn.com/problems/find-missing-observations/
 *
 */
public class LeetCode2028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length;
        int sum = mean * len;
        for (int i = 0; i < len; i++) {
            sum -= rolls[i];
        }

        if (sum + mean * n < n || sum + mean * n > n * 6) {
            return new int[0];
        }

        int[] arr = new int[n];

        sum += mean * n;
        int avg = sum / n, other = sum % n;
        for (int i = 0; i < n; i++) {
            arr[i] = avg + (i < other ? 1 : 0);
        }
        return arr;
    }

    public static void main(String[] args) {
        LeetCode2028 obj = new LeetCode2028();
        System.out.println(Arrays.toString(obj.missingRolls(new int[] { 3, 2, 4, 3 }, 4, 2)));
        System.out.println(Arrays.toString(obj.missingRolls(new int[] { 1, 5, 6 }, 3, 4)));
        System.out.println(Arrays.toString(obj.missingRolls(new int[] { 1, 2, 3, 4 }, 6, 4)));
        System.out.println(Arrays.toString(obj.missingRolls(new int[] { 1 }, 3, 1)));
    }

}
