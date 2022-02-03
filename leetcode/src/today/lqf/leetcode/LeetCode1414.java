package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1414 {

    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        while (list.get(list.size() - 1) + list.get(list.size() - 2) <= k) {
            list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
        }
        int cnt = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int cur = list.get(i);
            while (k >= cur) {
                k = k - cur;
                cnt++;
            }
            if (i == 0) {
                i++;
            }
            if (k == 0)
                break;
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode1414 obj = new LeetCode1414();
        System.out.println(obj.findMinFibonacciNumbers(7));
        System.out.println(obj.findMinFibonacciNumbers(10));
        System.out.println(obj.findMinFibonacciNumbers(19));

    }

}
