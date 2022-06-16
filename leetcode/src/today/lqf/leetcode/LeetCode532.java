package today.lqf.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode532 {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0, j = 1; i < nums.length; i++) {
            if (i == j) j++;
            for (; j < nums.length; j++) {
                if (nums[i] + k == nums[j]) {
                    set.add(nums[i] + "," + nums[j]);
                    j++;
                    break;
                }
                if (nums[i] + k < nums[j]) {
                    break;
                }
            }
        }
        return set.size();
    }
    
    public static void main(String[] args) {
        LeetCode532 obj = new LeetCode532();
        System.out.println(obj.findPairs(new int[] {3, 1, 4, 1, 5}, 2));

    }

}
