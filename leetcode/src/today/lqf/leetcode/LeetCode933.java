package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode933 {

    List<Integer> list;

    public LeetCode933() {
        list = new ArrayList<>();
    }
    
    public int ping(int t) {
        while(list.size() > 0) {
            if (list.get(0) >= t-3000) {
                break;
            }
            list.remove(0);
        }
        list.add(t);
        return list.size();
    }
    
    public static void main(String[] args) {
        LeetCode933 obj = new LeetCode933();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(2));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));

    }

}
