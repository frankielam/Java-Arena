package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode682 {

    public int calPoints(String[] ops) {
        int total = Integer.parseInt(ops[0]);
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(ops[0]));
        for (int i = 1; i < ops.length; i++) {
            String op = ops[i];
            int num = 0;
            if (op.equals("+")) {
                num = list.get(list.size() - 1) + list.get(list.size() - 2);
            } else if (op.equals("C")) {
                num = 0 - list.get(list.size() - 1);
                list.remove(list.size() - 1);
            } else if (op.equals("D")) {
                num = list.get(list.size() - 1) * 2;
            } else {
                num = Integer.parseInt(op);
            }
            if (!op.equals("C"))
                list.add(num);
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        LeetCode682 obj = new LeetCode682();
        System.out.println(obj.calPoints(new String[] { "5", "2", "C", "D", "+" }));
        System.out.println(obj.calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));
        System.out.println(obj.calPoints(new String[] { "1" }));
    }

}
