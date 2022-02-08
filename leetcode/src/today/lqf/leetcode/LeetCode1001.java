package today.lqf.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1001 {

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[] arr = new int[queries.length];
        Map<Long, Integer> lampMap = new HashMap<>();
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> slash = new HashMap<>();
        Map<Integer, Integer> backslash = new HashMap<>();
        for (int i = 0; i < lamps.length; i++) {
            int x = lamps[i][0], y = lamps[i][1];
            if (lampMap.getOrDefault(hash(x, y), 0) == 1)
                continue;
            lampMap.put(hash(x, y), 1);
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);
            slash.put(x - y, slash.getOrDefault(x - y, 0) + 1);
            backslash.put(x + y, backslash.getOrDefault(x + y, 0) + 1);
        }

        int[][] round = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { 1, -1 },
                { 1, 0 }, { 1, 1 }, };
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (row.getOrDefault(x, 0) > 0 || col.getOrDefault(y, 0) > 0 || slash.getOrDefault(x - y, 0) > 0
                    || backslash.getOrDefault(x + y, 0) > 0) {
                arr[i] = 1;
            }

            for (int j = 0; j < round.length; j++) {
                int x2 = x + round[j][0], y2 = y + round[j][1];
                if (lampMap.containsKey(hash(x2, y2))) {
                    lampMap.remove(hash(x2, y2));
                    row.put(x2, row.getOrDefault(x2, 0) - 1);
                    col.put(y2, col.getOrDefault(y2, 0) - 1);
                    slash.put(x2 - y2, slash.getOrDefault(x2 - y2, 0) - 1);
                    backslash.put(x2 + y2, backslash.getOrDefault(x2 + y2, 0) - 1);
                }
            }
        }
        return arr;
    }

    private static Long hash(int x, int y) {
        return ((long) x << 32) + (long) y;
    }

    public static void main(String[] args) {
        LeetCode1001 obj = new LeetCode1001();
        System.out.println(Arrays.toString(
                obj.gridIllumination(4, new int[][] { { 0, 0 }, { 3, 3 } }, new int[][] { { 1, 1 }, { 1, 0 } })));
        
        System.out.println(Arrays.toString(obj.gridIllumination(5, new int[][] { { 0, 0 }, { 0, 4 } },
                new int[][] { { 0, 4 }, { 0, 1 }, { 1, 4 } })));

        System.out.println(Arrays.toString(obj.gridIllumination(6,
                new int[][] { { 2, 5 }, { 4, 2 }, { 0, 3 }, { 0, 5 }, { 1, 4 }, { 4, 2 }, { 3, 3 }, { 1, 0 } },
                new int[][] { { 4, 3 }, { 3, 1 }, { 5, 3 }, { 0, 5 }, { 4, 4 }, { 3, 3 } })));
    }

}