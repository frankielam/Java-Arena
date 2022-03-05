package today.lqf.leetcode;


/**
 * 
 * https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 * — _ — 啥题目，阅读理解..... 
 *
 */
public class LeetCode521 {
    
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return a.length() > b.length() ? a.length() : b.length();
    }

    public static void main(String[] args) {
        LeetCode521 obj = new LeetCode521();
        System.out.println(obj.findLUSlength("aaa", "bbb"));
        System.out.println(obj.findLUSlength("abc", "cdc"));

    }

}
