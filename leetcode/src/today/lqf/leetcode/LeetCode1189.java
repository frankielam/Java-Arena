package today.lqf.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeetCode1189 {

    public int maxNumberOfBalloons(String text) {
        // 'ballon'
        Map<Character, Integer> map = new HashMap<>();
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);

        for (int i = 0; i < text.length(); i++) {
            if (map.containsKey(text.charAt(i))) {
                map.put(text.charAt(i), map.get(text.charAt(i)) + 1);
            }
        }

        Iterator<Integer> it = map.values().iterator();
        int min = text.length();
        while (it.hasNext()) {
            int n = it.next();
            if (n < min) {
                min = n;
            }
        }
        if (map.get('l') / 2 < min) {
            min = map.get('l') / 2;
        }
        if (map.get('o') / 2 < min) {
            min = map.get('o') / 2;
        }

        return min;
    }

    public static void main(String[] args) {
        LeetCode1189 obj = new LeetCode1189();
        System.out.println(obj.maxNumberOfBalloons("nlaebolko"));
        System.out.println(obj.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(obj.maxNumberOfBalloons("leetcode"));
    }

}
