package today.lqf.leetcode;

import java.util.Arrays;

public class LeetCode905 {

    public int[] sortArrayByParity(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j;) {
            if (nums[i] % 2 == 1) {
                if (nums[j] % 2 == 0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        LeetCode905 obj = new LeetCode905();
        System.out.println(Arrays.toString(obj.sortArrayByParity(new int[] { 3, 1, 2, 4 })));

    }

}
