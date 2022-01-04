package today.lqf.leetcode;

public class LeetCode1009 {

    public int bitwiseComplement(int n) {
        int num = 1;
        while (true) {
            num = num * 2;
            if (num > n)
                break;
        }
        System.out.println(n + "\t" + (num - 1));
        return n ^ (num - 1);
    }

    public static void main(String[] args) {
        LeetCode1009 obj = new LeetCode1009();
        int rst = obj.bitwiseComplement(1);
        System.out.println(rst);

    }

}
