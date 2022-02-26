package today.lqf.leetcode;

/**
 * https://leetcode-cn.com/problems/maximum-difference-between-increasing-elements/
 *
 */
public class LeetCode2016 {

    public int maximumDifference(int[] nums) {
        int sub = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= nums[j])
                    continue;
                if (nums[j] - nums[i] > sub) {
                    sub = nums[j] - nums[i];
                }
            }
        }
        return sub;
    }

    public static void main(String[] args) {
        LeetCode2016 obj = new LeetCode2016();
        System.out.println(obj.maximumDifference(new int[] { 7, 1, 5, 4 }));
        System.out.println(obj.maximumDifference(new int[] { 9, 4, 3, 2 }));
    }

}
