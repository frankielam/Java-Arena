package today.lqf.leetcode;

public class LeetCode1422 {

    public int maxScore(String s) {
        int len = s.length();
        int[] left = new int[len], right = new int[len];
        int l = 0, r = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                l++;
            }
            left[i] = l;
            if (s.charAt(len - 1 - i) == '1') {
                r++;
            }
            right[len - 1 - i] = r;
        }
        if (l == 0 || r == 0) {
            return len - 1;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0 && s.charAt(i) == '1') {
                continue;
            }
            if (i == len - 1 && s.charAt(i) == '0') {
                continue;
            }
            if (left[i] + right[i] > max) {
                max = left[i] + right[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LeetCode1422 obj = new LeetCode1422();
        System.out.println(obj.maxScore("11100"));
        System.out.println(obj.maxScore("00111"));
        System.out.println(obj.maxScore("11111"));
        System.out.println(obj.maxScore("00000"));
        System.out.println(obj.maxScore("101010"));
    }

}
