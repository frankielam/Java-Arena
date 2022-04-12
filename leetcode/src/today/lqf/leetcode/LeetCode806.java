package today.lqf.leetcode;

import java.util.Arrays;

public class LeetCode806 {

    public int[] numberOfLines(int[] widths, String s) {
        int len = s.length();
        int line = 0, cnt = 0;
        for (int i = 0; i < len; i++) {
            int p = s.charAt(i) - 'a';
            int l = widths[p];
            cnt += l;
            if (cnt >= 100) {
                line++;
                if (cnt > 100) {
                    cnt = l;
                } else {
                    cnt = 0;
                }
            }
        }
        if (cnt > 0) {
            line++;
            return new int[] { line, cnt };
        }
        return new int[] { line, 100 };
    }

    public static void main(String[] args) {
        LeetCode806 obj = new LeetCode806();
        System.out.println(Arrays.toString(obj.numberOfLines(new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, "abcdefghijklmnopqrstuvwxyz")));
        System.out.println(Arrays.toString(obj.numberOfLines(new int[] { 4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, "bbbcccdddaaa")));

    }

}
