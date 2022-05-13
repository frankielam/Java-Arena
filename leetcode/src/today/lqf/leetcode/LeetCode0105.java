package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/one-away-lcci/
 */
public class LeetCode0105 {

    public boolean oneEditAway(String first, String second) {
        int len1 = first.length(), len2 = second.length();
        if (len1 - len2 > 1 || len1 - len2 < -1) {
            return false;
        }
        if (len1 == len2) {
            for (int i = 0, cnt = 0; i < len1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    cnt++;
                }
                if (cnt > 1) {
                    return false;
                }
            }
        } else {
            for (int i = 0, j = 0, cnt = 0; i < first.length() && j < second.length(); i++, j++) {
                if (first.charAt(i) != second.charAt(j)) {
                    cnt++;
                    if (first.length() < second.length()) {
                        i--;
                    } else {
                        j--;
                    }
                }
                if (cnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0105 obj = new LeetCode0105();
        System.out.println(obj.oneEditAway("", "a"));
        System.out.println(obj.oneEditAway("pale", "ple"));
        System.out.println(obj.oneEditAway("pales", "pal"));
    }

}
