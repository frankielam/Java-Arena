package today.lqf.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 */
public class LeetCode1460 {

    public boolean canBeEqual2(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : target) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            int cnt = map.getOrDefault(num, 0);
            if (cnt == 0) {
                return false;
            }
            map.put(num, cnt - 1);
            if (cnt == 1) {
                map.remove(num);
            }
        }
        if (map.size() > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1460 obj = new LeetCode1460();
        System.out.println(obj.canBeEqual(new int[] { 1, 2, 3, 4 }, new int[] { 2, 3, 1, 4 }));
        System.out.println(obj.canBeEqual2(new int[] { 1, 2, 3, 4 }, new int[] { 2, 3, 1, 4 }));
    }

}
