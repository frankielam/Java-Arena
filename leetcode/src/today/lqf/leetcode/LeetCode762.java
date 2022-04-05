package today.lqf.leetcode;

public class LeetCode762 {

    public int countPrimeSetBits(int left, int right) {
        int rst = 0;
        int[] arr = new int[] { 2, 3, 5, 7, 11, 13, 17, 19 };
        for (int i = left; i <= right; i++) {
            int n = Integer.bitCount(i);
            boolean f = false;
            for (int j = 0; j < arr.length; j++) {
                if (n == arr[j]) {
                    f = true;
                    break;
                } else if (n < arr[j]) {
                    break;
                }
            }
            if (f) {
                rst++;
            }

        }

        return rst;
    }

    public static void main(String[] args) {
        LeetCode762 obj = new LeetCode762();
        System.out.println(obj.countPrimeSetBits(6, 10));

    }

}
