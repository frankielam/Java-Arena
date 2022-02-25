package today.lqf.leetcode;

/**
 * https://leetcode-cn.com/problems/complex-number-multiplication/
 *
 */
public class LeetCode537 {

    public String complexNumberMultiply(String num1, String num2) {
        String[] str1 = num1.split("\\+");
        String[] str2 = num2.split("\\+");
        int a1 = Integer.parseInt(str1[0]);
        int a2 = Integer.parseInt(str1[1].replace("i", ""));
        int b1 = Integer.parseInt(str2[0]);
        int b2 = Integer.parseInt(str2[1].replace("i", ""));

        int n1 = a1 * b1 + a2 * b2 * -1;
        int n2 = a1 * b2 + a2 * b1;

        return n1 + "+" + n2 + "i";
    }

    public static void main(String[] args) {
        LeetCode537 obj = new LeetCode537();
        System.out.println(obj.complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(obj.complexNumberMultiply("1+-1i", "1+-1i"));
    }

}