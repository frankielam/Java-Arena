package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2013 {

    Map<Integer, List<Integer>> xMap = new HashMap<>();
    Map<Integer, Integer> map = new HashMap<>();

    public LeetCode2013() {
        xMap = new HashMap<>();
        map = new HashMap<>();
    }

    public void add(int[] point) {
        List<Integer> yList = new ArrayList<>();
        if (xMap.containsKey(point[0])) {
            yList = xMap.get(point[0]);
        }
        yList.add(point[1]);
        xMap.put(point[0], yList);
        int p = point[0] * 10000 + point[1];
        map.put(p, map.getOrDefault(p, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int cnt = 0;
        if (xMap.containsKey(x)) {
            List<Integer> yList = xMap.get(x);
            for (int i = 0; i < yList.size(); i++) {
                int len = y - yList.get(i);
                if (len == 0)
                    continue;
                int p1 = (x + len) * 10000 + y;
                int p2 = (x + len) * 10000 + (y - len);
                if (map.containsKey(p1) && map.containsKey(p2)) {
                    cnt += map.get(p1) * map.get(p2);
                }
                int p3 = (x - len) * 10000 + y;
                int p4 = (x - len) * 10000 + (y - len);
                if (map.containsKey(p3) && map.containsKey(p4)) {
                    cnt += map.get(p3) * map.get(p4);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode2013 obj = new LeetCode2013();
        obj.add(new int[] { 3, 10 });
        obj.add(new int[] { 11, 2 });
        obj.add(new int[] { 3, 2 });
        obj.add(new int[] { 11, 2 });

        System.out.println(obj.count(new int[] { 11, 10 }));
    }

}
