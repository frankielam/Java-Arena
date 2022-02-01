package today.lqf.leetcode;

public class LeetCode1763 {

    public String longestNiceSubstring(String s) {
        int len = s.length();
        int start = 0, length = 0;
        for (int i = 0; i < len; i++) {
            int lower = 0;
            int upper = 0;
            for (int j = i; j < len; j++) {
                if (s.charAt(j) < 'a') { // upper letter
                    upper |= 1 << (s.charAt(j) - 'A');
                } else {
                    lower |= 1 << (s.charAt(j) - 'a');
                }
                if (lower == upper) {
                    if (j - i + 1 > length) {
                        start = i;
                        length = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, start + length);
    }

    public static void main(String[] args) {
        LeetCode1763 obj = new LeetCode1763();
        System.out.println(obj.longestNiceSubstring("YazaAay"));
        System.out.println(obj.longestNiceSubstring("Bb"));
        System.out.println(obj.longestNiceSubstring("c"));
        System.out.println(obj.longestNiceSubstring("dDzeE"));
        System.out.println(obj.longestNiceSubstring("dDzeEZ"));
    }

}
