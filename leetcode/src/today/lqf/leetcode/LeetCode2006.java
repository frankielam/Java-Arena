package today.lqf.leetcode;

import java.util.Arrays;

public class LeetCode2006 {

    public int countKDifference(int[] nums, int k) {
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == k) {
                    cnt++;
                } else if (nums[j] - nums[i] > k) {
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode2006 obj = new LeetCode2006();
        System.out.println(obj.countKDifference(new int[] { 1, 2, 2, 1 }, 1));
        System.out.println(obj.countKDifference(new int[] { 1, 3 }, 3));
        System.out.println(obj.countKDifference(new int[] { 3, 2, 1, 5, 4 }, 2));

    }

}
