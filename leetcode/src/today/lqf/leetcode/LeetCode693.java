package today.lqf.leetcode;

public class LeetCode693 {

    public boolean hasAlternatingBits(int n) {
        int k = n % 2;
        n /= 2;
        while (n > 0) {
            if (n % 2 == k) {
                return false;
            }
            k = n % 2;
            n /= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode693 obj = new LeetCode693();
        System.out.println(obj.hasAlternatingBits(5));
        System.out.println(obj.hasAlternatingBits(7));
        System.out.println(obj.hasAlternatingBits(11));
    }

}
