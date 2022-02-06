package today.lqf.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1748 {

    public int sumOfUnique2(int[] nums) {
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]).intValue() == 1) {
                    total -= nums[i];
                    map.put(nums[i], 0);
                }
            } else {
                total += nums[i];
                map.put(nums[i], 1);
            }
        }
        return total;
    }

    public int sumOfUnique(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int total = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[0] != nums[1]) {
                    total += nums[0];
                }
            } else if (i == nums.length - 1) {
                if (nums[nums.length - 2] != nums[nums.length - 1]) {
                    total += nums[nums.length - 1];
                }
            } else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    total += nums[nums.length - 1];
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        LeetCode1748 obj = new LeetCode1748();
        System.out.println(obj.sumOfUnique(new int[] { 1, 2, 3, 2 }));
        System.out.println(obj.sumOfUnique(new int[] { 1, 1, 1, 1, 1 }));
        System.out.println(obj.sumOfUnique(new int[] { 1, 2, 3, 4, 5 }));
    }

}
