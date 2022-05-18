package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 */
public class LeetCode668 {

    public int findKthNumber(int m, int n, int k) {
        int start = 1, end = m * n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = mid / n * n;
            for (int i = mid / n + 1; i <= m; i++) {
                sum += mid / i;
            }
            if (sum >= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        LeetCode668 obj = new LeetCode668();
        System.out.println(obj.findKthNumber(9895, 28405, 100787757));

    }

}
