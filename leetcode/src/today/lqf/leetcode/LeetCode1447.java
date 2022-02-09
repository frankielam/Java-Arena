package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1447 {

    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        for (int i = 3; i <= 100; i++) {
            boolean f = true;
            for (int j = 0; j < arr.size(); j++) {
                if (i % arr.get(j) == 0) {
                    f = false;
                    break;
                }
            }
            if (f) {
                arr.add(i);
            }
        }

        for (int i = 2; i <= n; i++) {
            list.add(1 + "/" + i);
            for (int j = 2; j < i; j++) {
                boolean f = true;
                for (int k = 0; k < arr.size(); k++) {
                    if (arr.get(k) > i) break; 
                    if (i % arr.get(k) == 0 && j % arr.get(k) == 0) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    list.add(j + "/" + i);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode1447 obj = new LeetCode1447();
//        System.out.println(Arrays.toString(obj.simplifiedFractions(1).toArray()));
//        System.out.println(Arrays.toString(obj.simplifiedFractions(2).toArray()));
//        System.out.println(Arrays.toString(obj.simplifiedFractions(3).toArray()));
//        System.out.println(Arrays.toString(obj.simplifiedFractions(4).toArray()));
        System.out.println(Arrays.toString(obj.simplifiedFractions(100).toArray()));

    }

}
