package today.lqf.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/shuffle-the-array/
 */
public class LeetCode1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < n; i++) {
            arr[i * 2] = nums[i];
            arr[i * 2 + 1] = nums[i + n];
        }
        return arr;
    }

    public static void main(String[] args) {
        LeetCode1470 obj = new LeetCode1470();
        System.out.println(Arrays.toString(obj.shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3)));
        System.out.println(Arrays.toString(obj.shuffle(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }, 4)));
        System.out.println(Arrays.toString(obj.shuffle(new int[] { 1, 1, 2, 2 }, 2)));

    }

}
