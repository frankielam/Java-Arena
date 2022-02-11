package today.lqf.leetcode;

import java.util.Arrays;

public class LeetCode1984 {

    public int minimumDifference(int[] nums, int k) {
        if (k == 1)
            return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = k; i <= nums.length; i++) {
            int val = nums[i - 1] - nums[i - k];
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode1984 obj = new LeetCode1984();
        System.out.println(obj.minimumDifference(new int[] { 90 }, 1));
        System.out.println(obj.minimumDifference(new int[] { 9, 4, 1, 7 }, 2));

    }

}
