package today.lqf.leetcode;

public class LeetCode1332 {

    //「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
    
    public int removePalindromeSub(String s) {
        StringBuffer sb = new StringBuffer(s);
        if (s.equals(sb.reverse().toString())) {
            return 1;
        }
        return 2;
    }

    public int removePalindromeSub2(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) !=  s.charAt(s.length() - i - 1)) {
                return  2;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        LeetCode1332 obj = new LeetCode1332();
        String s = "ababba";
        System.out.println(obj.removePalindromeSub(s));
    }

}
