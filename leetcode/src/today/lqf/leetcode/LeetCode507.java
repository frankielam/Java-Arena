package today.lqf.leetcode;

public class LeetCode507 {

    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num/2; i++) {
            if (num % i == 0) {
                int j = num / i;
                if (i > j) break;
                sum += i;
                if (i == j) {
                    break;
                } else if (j != num) {
                    sum += j;
                }
            }
        }
        return sum == num;
    }
    
    public static void main(String[] args) {
        LeetCode507 obj = new LeetCode507();
        System.out.println(obj.checkPerfectNumber(1));
        System.out.println(obj.checkPerfectNumber(28));

    }

}
