package today.lqf.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode961 {

    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode961 obj = new LeetCode961();
        System.out.println(obj.repeatedNTimes(new int[] { 5, 1, 5, 2, 5, 3, 5, 4 }));

    }

}
