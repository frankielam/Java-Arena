package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.cn/problems/my-calendar-i/
 */
public class LeetCode729 {

    List<List<Integer>> list;

    public LeetCode729() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        boolean f = true;
        if (list.size() > 0) {
            for (List<Integer> item : list) {
                if (end < item.get(0).intValue()) {
                    break;
                }
                if (item.get(0).intValue() <= start && start < item.get(1).intValue()
                        || item.get(0).intValue() < end && end <= item.get(1).intValue()
                        || start < item.get(0).intValue() && item.get(1).intValue() < end) {
                    f = false;
                    break;
                }

            }
        }
        if (f) {
            List<Integer> item = new ArrayList<>();
            item.add(start);
            item.add(end);
            list.add(item);
            Collections.sort(list, (a, b) -> {
                return a.get(0) - b.get(0);
            });
        }
        return f;
    }

    public static void main(String[] args) {
        LeetCode729 obj = new LeetCode729();
        System.out.println(obj.book(10, 20));
        System.out.println(obj.book(15, 25));
        System.out.println(obj.book(30, 40));

    }

}
