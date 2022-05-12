package today.lqf.leetcode;

public class LeetCode944 {

    public int minDeletionSize(String[] strs) {
        int cnt = 0;
        int cols = strs[0].length();
        for (int i = 0; i < cols; i++) {
            char c = 'a';
            boolean match = true;
            for (String str : strs) {
                if (str.charAt(i) < c) {
                    match = false;
                    break;
                }
                c = str.charAt(i);
            }
            if (!match) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        LeetCode944 obj = new LeetCode944();
        System.out.println(obj.minDeletionSize(new String[] { "abc", "bce", "cae" }));

    }

}
