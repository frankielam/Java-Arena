package today.lqf.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int iVal = map.get(nums[i]);
                if (i - iVal <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
    
    public static void main(String[] args) {
        LeetCode219 obj = new LeetCode219();
        int[] nums = {1, 2, 3, 1, 2, 3};
        boolean rst = obj.containsNearbyDuplicate(nums, 3);
        System.out.println(rst);
                

    }

}
