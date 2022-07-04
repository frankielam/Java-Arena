package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        boolean first = true;
        int pre = 0, min = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for (int num : arr) {
            if (first) {
                pre = num;
                first = false;
            } else {
                if (num - pre <= min) {
                    if (num - pre < min) {
                        min = num - pre;
                        list = new ArrayList<>();
                    }
                    List<Integer> subList = new ArrayList<>();
                    subList.add(pre);
                    subList.add(num);
                    list.add(subList);
                }
                pre = num;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode1200 obj = new LeetCode1200();
        System.out.println(obj.minimumAbsDifference(new int[] {2, 1, 4, 3}));
    }

}
