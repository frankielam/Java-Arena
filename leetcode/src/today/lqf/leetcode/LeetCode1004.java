package today.lqf.leetcode;

/**
 * 
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 *
 */
public class LeetCode1004 {

    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int max = 0;
        for (int l = 0, r = 0, sum = 0; r < len; r++) {
            if (nums[r] == 0) {
                sum++;
            }
            while (sum > k) {
                if (nums[l++] == 0) {
                    sum--;
                }
            }
            max = Math.max(max, r - l + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        LeetCode1004 obj = new LeetCode1004();
        System.out.println(obj.longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
        System.out.println(obj.longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3));
    }

}
