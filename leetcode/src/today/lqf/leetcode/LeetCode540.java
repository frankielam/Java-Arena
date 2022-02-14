package today.lqf.leetcode;

import java.util.Arrays;

public class LeetCode540 {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        Arrays.sort(nums);
        int n = 0, m = nums.length - 1;
        while (m > n) {
            int middle = n + (m - n) / 2;
            if (nums[middle] == nums[middle - 1]) {
                if ((middle - n) % 2 == 0) {
                    m = middle;
                } else {
                    n = middle + 1;
                }
            } else {
                if ((middle - n) % 2 == 0) {
                    n = middle;
                } else {
                    m = middle - 1;
                }
            }
        }
//        if (nums[n] == nums[n + 1]) {
//            return nums[m];
//        } else {
//            return nums[n];
//        }
        return nums[m];
    }

    public static void main(String[] args) {
        LeetCode540 obj = new LeetCode540();
        System.out.println(obj.singleNonDuplicate(new int[] { 1 }));
        System.out.println(obj.singleNonDuplicate(new int[] { 1, 1, 2 }));
        System.out.println(obj.singleNonDuplicate(new int[] { 1, 2, 2 }));
        System.out.println(obj.singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
        System.out.println(obj.singleNonDuplicate(new int[] { 3, 7, 7, 10, 10, 11, 11 }));
        System.out.println(obj.singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
        System.out.println(obj.singleNonDuplicate(new int[] { 1, 1, 2, 2, 4, 4, 5, 5, 9 }));

    }

}
