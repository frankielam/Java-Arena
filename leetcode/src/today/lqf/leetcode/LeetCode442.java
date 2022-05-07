package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 */
public class LeetCode442 {

    public List<Integer> findDuplicates2(int[] nums) {
        Arrays.sort(nums);
        int pre = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            if (pre == n) {
                list.add(n);
            }
            pre = n;
        }
        return list;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // Set<Integer> set = new HashSet<>();
        int[] arr = new int[nums.length + 1];
        for (int n : nums) {
            if (arr[n] == 1) {
                list.add(n);
            }
            arr[n] = 1;
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode442 obj = new LeetCode442();
        System.out.println(obj.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));

    }

}
