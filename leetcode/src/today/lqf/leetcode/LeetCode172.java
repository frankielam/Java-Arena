package today.lqf.leetcode;

/*
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
public class LeetCode172 {

    public int trailingZeroes(int n) {
        int cnt = 0;
        int i = 0;
        while (n >= ++i * 5) {
            cnt++;
            int p = i;
            while (p % 5 == 0) {
                cnt++;
                p = p / 5;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode172 obj = new LeetCode172();
        System.out.println(obj.trailingZeroes(5));
        System.out.println(obj.trailingZeroes(25));
        System.out.println(obj.trailingZeroes(30));
        System.out.println(obj.trailingZeroes(125));
        System.out.println(obj.trailingZeroes(300));
    }

}
