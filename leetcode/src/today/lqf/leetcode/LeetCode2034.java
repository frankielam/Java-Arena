package today.lqf.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <url>https://leetcode-cn.com/problems/stock-price-fluctuation/</url>
 * @author frankielam
 *
 */
public class LeetCode2034 {

    Map<Integer, Integer> map;
    TreeMap<Integer, Integer> treeMap;
    int cur = 0;

    public LeetCode2034() {
        map = new HashMap<>();
        treeMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            int prePrice = map.get(timestamp);
            // 相同 price 值时 -1 （仅剩一个删除）
            if (treeMap.get(prePrice) > 1) {
                treeMap.put(prePrice, treeMap.get(prePrice) - 1);       
            } else {
                treeMap.remove(prePrice);
            }
        } else {
            if (timestamp > cur) {
                cur = timestamp;
            }
        }
        map.put(timestamp, price);
        treeMap.put(price, treeMap.getOrDefault(price, 0) + 1); // 相同 price 值时 +1

    }

    public int current() {
        return map.get(cur);
    }

    public int maximum() {
        return treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }

    public static void main(String[] args) {
        LeetCode2034 obj = new LeetCode2034();
        obj.update(1, 2);
        obj.update(2, 1);
        obj.update(1, 4);
        obj.update(2, 3);
        System.out.println(obj.current());
        System.out.println(obj.maximum());
        System.out.println(obj.minimum());
    }

}
