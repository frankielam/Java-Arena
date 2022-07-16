package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/qIsx9U/
 */
public class LeetCode041 {

    int[] arr;
    int idx = 0;        // 单指针
    int total = 0, cnt = 0;

    /** Initialize your data structure here. */
    public LeetCode041(int size) {
        arr = new int[size];
        idx = 0;
        total = 0;
    }

    public double next(int val) {
        if (idx == arr.length) {
            idx = 0;
        }
        total -= arr[idx];      // 减去最第一个
        total += val;           // 加上最新的
        arr[idx++] = val;
        if (cnt < arr.length)
            cnt++;
        return total * 1.0d / cnt;
    }

    public static void main(String[] args) {
        LeetCode041 obj = new LeetCode041(3);
        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
    }

}
