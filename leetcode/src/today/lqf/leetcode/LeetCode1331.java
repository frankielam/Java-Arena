package today.lqf.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/rank-transform-of-an-array/
 */
public class LeetCode1331 {

    public int[] arrayRankTransform(int[] arr) {
        int[] sortArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortArr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, key = 1; i < sortArr.length; i++) {
            if (!map.containsKey(sortArr[i])) {
                map.put(sortArr[i], key++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        LeetCode1331 obj = new LeetCode1331();
        System.out.println(Arrays.toString(obj.arrayRankTransform(new int[] {10, 30, 20, 40})));
    }

}
