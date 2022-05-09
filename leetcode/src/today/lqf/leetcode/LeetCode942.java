package today.lqf.leetcode;

import java.util.Arrays;

public class LeetCode942 {

    public int[] diStringMatch(String s) {
        int len = s.length();
        int[] arr = new int[len + 1];
        for (int i = 0, st = 0, e = len; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                arr[i] = st++;
            } else {
                arr[i] = e--;
            }
            if (i == len - 1) {
                arr[i + 1] = st;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        LeetCode942 obj = new LeetCode942();
        System.out.println(Arrays.toString(obj.diStringMatch("IDID")));
        System.out.println(Arrays.toString(obj.diStringMatch("III")));
    }

}
