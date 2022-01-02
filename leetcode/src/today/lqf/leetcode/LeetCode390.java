package today.lqf.leetcode;

public class LeetCode390 {

    public int lastRemaining(int n) {

        int first = 1;
        int t = 0, step = 1, cnt = n;
        while (cnt > 1) {
            if (t % 2 == 0) {
                first = first + step;
            } else {
                first = cnt % 2 == 0 ? first : first + step;
            }
            t++;
            step = step * 2;
            cnt = cnt / 2;
        }
        return first;
    }

    public static void main(String[] args) {
        LeetCode390 obj = new LeetCode390();
        int n = obj.lastRemaining(100000000);
        System.out.println(n);

    }

}
