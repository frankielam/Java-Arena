package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int n = i;
            boolean fail = false;
            while (n > 0) {
                if (n % 10 == 0 || i % (n % 10) != 0) {
                    fail = true;
                    break;
                }
                n = n / 10;
            }
            if (!fail) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode728 obj = new LeetCode728();
        System.out.println(obj.selfDividingNumbers(1, 22));
        System.out.println(obj.selfDividingNumbers(47, 85));

    }

}
