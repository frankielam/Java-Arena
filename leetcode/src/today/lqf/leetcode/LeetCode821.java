package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode821 {

    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (c == s.charAt(i)) {
                list.add(i);
            }
        }

        int[] arr = new int[len];
        int idx = 0, e = 0;
        for (int i = 0; i < len; i++) {
            arr[i] = Math.min(Math.abs(i - list.get(idx)), Math.abs(list.get(e) - i));

            if (i >= list.get(e)) {
                if (e < list.size() - 1) {
                    e++;
                    if (e - idx > 1) {
                        idx = e - 1;
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
