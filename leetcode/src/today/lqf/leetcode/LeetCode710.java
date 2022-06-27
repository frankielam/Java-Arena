package today.lqf.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/*
 * https://leetcode.cn/problems/random-pick-with-blacklist/
 * Map
 */
public class LeetCode710 {

    Random random = new Random();
    int size = 0;
    Map<Integer, Integer> map;

    public LeetCode710(int n, int[] blacklist) {
        size = n - blacklist.length;
        Set<Integer> set = new HashSet<>();
        for (int i : blacklist) {
            if (i >= size)
                set.add(i);
        }
        map = new HashMap<>();
        for (int i = 0, j = n - 1; i < blacklist.length; i++) {
            if (blacklist[i] < size) {
                while (set.contains(j)) {
                    j--;
                }
                map.put(blacklist[i], j--);
            }
        }
    }

    public int pick() {
        int num = random.nextInt(size);
        return map.getOrDefault(num, num);
    }

    public static void main(String[] args) {
        LeetCode710 obj = new LeetCode710(7, new int[] { 2, 3, 5 });
        System.out.println(obj.pick());
        System.out.println(obj.pick());
        System.out.println(obj.pick());
        System.out.println(obj.pick());
    }
}
