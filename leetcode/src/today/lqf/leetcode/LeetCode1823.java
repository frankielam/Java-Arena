package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 */
public class LeetCode1823 {

    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        int i = 0, t = k;
        while (list.size() > 1) {
//            System.out.println(list);
            t--;
            if (t == 0) {
                list.remove(i);
                t = k;
            } else {
                i++;
            }
            if (i >= list.size()) {
                i = 0;
            }

        }
        return list.get(0);
    }

    public static void main(String[] args) {
        LeetCode1823 obj = new LeetCode1823();
        System.out.println(obj.findTheWinner(5, 2));

    }

}
