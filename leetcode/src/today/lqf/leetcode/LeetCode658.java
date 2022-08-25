package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.cn/problems/find-k-closest-elements/
 */
public class LeetCode658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                list.add(arr[i]);
            } else {
                int diff = Math.abs(list.get(0) - x) - Math.abs(arr[i] - x);
                if (diff == 0) {
                    continue;
                }
                if (diff < 0) {
                    break;
                }
                list.remove(0);
                list.add(arr[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode658 obj = new LeetCode658();
        System.out.println(obj.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
        System.out.println(obj.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 6));
    }

}
