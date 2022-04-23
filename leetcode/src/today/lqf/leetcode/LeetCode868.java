package today.lqf.leetcode;

public class LeetCode868 {

    public int binaryGap(int n) {
        int rst = 0;
        String str = Integer.toBinaryString(n);
        boolean f = true;
        for (int i = 0, cnt = 0; i < str.length(); i++) {
            if (f) {
                if (str.charAt(i) == '1') {
                    f = false;
                }
                continue;
            }
            if (str.charAt(i) == '0') {
                cnt++;
            } else {
                rst = Math.max(rst, cnt + 1);
                cnt = 0;
            }

        }

        return rst;
    }

    public static void main(String[] args) {
        LeetCode868 obj = new LeetCode868();
        System.out.println(obj.binaryGap(22));
        System.out.println(obj.binaryGap(8));
        System.out.println(obj.binaryGap(6));// 420

    }

}
