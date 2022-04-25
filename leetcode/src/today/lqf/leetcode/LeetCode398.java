package today.lqf.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class LeetCode398 {

    Map<Integer, Object> map = new HashMap<>();
    Random random = new Random();

    public LeetCode398(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Set<Integer> set = new HashSet<>();
                if (map.get(nums[i]).getClass() == HashSet.class) {
                    set = (Set<Integer>) map.get(nums[i]);
                } else {
                    set.add((int) map.get(nums[i]));
                }
                set.add(i);
                map.put(nums[i], set);
            } else {
                map.put(nums[i], i);
            }
        }
    }

    public int pick(int target) {

        if (map.get(target).getClass() == HashSet.class) {
            Set<Integer> set = (Set<Integer>) map.get(target);
            int n = set.size();
            Integer[] arr = new Integer[n];
            return set.toArray(arr)[random.nextInt(n)];

        }
        return (int) map.get(target);
    }

    public static void main(String[] args) {
        LeetCode398 obj = new LeetCode398(new int[] { 1, 2, 3, 3, 3 });
//        System.out.println(obj.pick(1));
//        System.out.println(obj.pick(2));
        System.out.println(obj.pick(3));
//        System.out.println(obj.pick(3));
//        System.out.println(obj.pick(3));

    }

}
