package today.lqf.leetcode;

/**
 * 
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/submissions/
 *
 */
public class LeetCode357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;

        int sum = 10;
        for (int i = 2; i <= n; i++) {
            int total = 9;
            for (int j = 1; j < i; j++) {
                total = total * (10 - j);
            }
            sum += total;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode357 obj = new LeetCode357();
        System.out.println(obj.countNumbersWithUniqueDigits(2));
        System.out.println(obj.countNumbersWithUniqueDigits(0));
        System.out.println(obj.countNumbersWithUniqueDigits(8));
    }

}
