package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1996 {

    public int numberOfWeakCharacters(int[][] properties) {
//        System.out.println(Arrays.deepToString(properties));
        Arrays.sort(properties, (a, b) -> a[0] - b[0]);
//        System.out.println(Arrays.deepToString(properties));
        int cnt = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < properties.length; i++) {
            int attack = properties[i][0];
            int defense = properties[i][1];
            if (defense > max) {
                max = defense;
                for (int j = 0; j < list.size(); ) {
                    if (attack > list.get(j).get(0)) {
                        cnt++;
                        list.remove(j);
                    } else {
                        j++;
                    }
                }
            }
            else if (defense < min) {
                min = defense;
            }
            else {
                for (int j = 0; j < list.size(); ) {
                    if (attack > list.get(j).get(0) && defense > list.get(j).get(1)) {
                        cnt++;
                        list.remove(j);
                    } else {
                        j++;
                    }
                }
            }
            List item = new ArrayList<>();
            item.add(attack);
            item.add(defense);
            list.add(item);
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode1996 obj = new LeetCode1996();
//        int[][] arr = { { 5, 5 }, { 6, 3 }, { 3, 6 } };
        int[][] arr = { { 1, 5 }, { 10, 4 }, {4, 3}};
        System.out.println(obj.numberOfWeakCharacters(arr));
        
    }

}
