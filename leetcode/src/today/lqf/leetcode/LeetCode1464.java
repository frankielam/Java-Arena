package today.lqf.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
 */
public class LeetCode1464 {

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
//        Arrays.sort(nums, (a, b) -> a - b );  // compile error, nums must be an Object array, e.g. Integer[] nums
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public static void main(String[] args) {
        LeetCode1464 obj = new LeetCode1464();
        System.out.println(obj.maxProduct(new int[] { 1, 2, 3, 4, 5, 6 }));

    }

}
