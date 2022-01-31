package today.lqf.leetcode;

public class LeetCode1342 {

    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num > 0) {
            if (num % 2 != 0) {
                num = num - 1;
            } else {
                num = num / 2;
            }
            cnt++;
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        LeetCode1342 obj = new LeetCode1342();
        System.out.println(obj.numberOfSteps(123));
    }

}
