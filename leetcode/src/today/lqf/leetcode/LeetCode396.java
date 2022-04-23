package today.lqf.leetcode;

import java.util.Arrays;

/*
 * https://leetcode-cn.com/problems/rotate-function/
 */
public class LeetCode396 {

    public int maxRotateFunction(int[] nums) {
//        F(0) 
//        F(1) = F(0) + numberSum - n * arr[n-1]
        int sum = Arrays.stream(nums).sum();
        int f0 = 0;
        for (int i = 0; i < nums.length; i++) {
            f0 += i * nums[i];
        }
        int max = f0;
        for (int i = 1; i < nums.length; i++) {
            f0 = f0 + sum - nums.length *  nums[nums.length-i];
            max = Math.max(f0, max);
        }

        return max;
    }

    public static void main(String[] args) {
        LeetCode396 obj = new LeetCode396();
        System.out.println(obj.maxRotateFunction(new int[] { 4, 3, 2, 6 }));
        System.out.println(obj.maxRotateFunction(new int[] { 100 }));

    }

}
