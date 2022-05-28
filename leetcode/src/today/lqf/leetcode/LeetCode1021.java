package today.lqf.leetcode;

public class LeetCode1021 {

    public String removeOuterParentheses(String s) {
        int idx = 0;
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                idx++;
                if (idx > 1) {
                    sb.append(c);
                }
            } else {
                idx--;
                if (idx > 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        LeetCode1021 obj = new LeetCode1021();
        System.out.println(obj.removeOuterParentheses("(()())(())"));
        System.out.println(obj.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(obj.removeOuterParentheses("()()"));
    }

}
