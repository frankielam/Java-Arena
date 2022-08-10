package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/solve-the-equation/
 */
public class LeetCode640 {

    public String solveEquation(String equation) {
        int left = 0, right = 0;
        boolean negative = false, matchEquals = false;
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (c == 'x') {
                left += negative ? -1 : 1;
                negative = matchEquals ? true : false;
            } else if (c == '-') {
                negative = matchEquals ? false : true;
            } else if (c == '+') {
                negative = matchEquals ? true : false;
            } else if (c == '=') {
                matchEquals = true;
                negative = true;
            } else if (c >= '0' && c <= '9') {
                StringBuffer sb = new StringBuffer();
                sb.append(c);
                for (int j = i + 1; j < equation.length(); j++) {
                    c = equation.charAt(j);
                    if (c < '0' || c > '9') {
                        break;
                    }
                    sb.append(c);
                    i++;
                }
                int num = Integer.valueOf(sb.toString());
                if (c == 'x') {
                    left += num * (negative ? -1 : 1);
                    i++;
                } else {
                    right += num * (negative ? 1 : -1);
                }
            }
        }
        if (left == 0) {
            return right == 0 ? "Infinite solutions" : "No solution";
        }
        return "x" + "=" + right / left;
    }

    public static void main(String[] args) {
        LeetCode640 obj = new LeetCode640();
        System.out.println(obj.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(obj.solveEquation("x=x"));
        System.out.println(obj.solveEquation("2x=x"));

    }

}
