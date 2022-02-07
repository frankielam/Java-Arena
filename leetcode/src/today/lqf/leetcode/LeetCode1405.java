package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode1405 {

    public String longestDiverseString(int a, int b, int c) {
        StringBuffer str = new StringBuffer();

        List<Letter> list = new ArrayList<>();
        if (a > 0)
            list.add(new Letter("a", a));
        if (b > 0)
            list.add(new Letter("b", b));
        if (c > 0)
            list.add(new Letter("c", c));

        while (true) {
            Collections.sort(list, (x, y) -> y.time - x.time);
            String l = list.get(0).letter;

            if (str.toString().endsWith(l)) {
                if (list.size() <= 1)
                    break;

                if (list.get(1).time > 0) {
                    str.append(list.get(1).letter);
                    list.get(1).time--;
                }

                if (list.get(1).time == 0) {
                    list.remove(1);
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    if (list.get(0).time > 0) {
                        str.append(list.get(0).letter);
                        list.get(0).time--;
                    }
                }
                if (list.get(0).time == 0) {
                    list.remove(0);
                }
            }

            if (list.size() == 0)
                break;

        }

        return str.toString();
    }

    public static void main(String[] args) {
        LeetCode1405 obj = new LeetCode1405();
        System.out.println(obj.longestDiverseString(1, 1, 7));
        System.out.println(obj.longestDiverseString(2, 2, 1));
        System.out.println(obj.longestDiverseString(7, 1, 0));
    }

    class Letter {
        int time;
        String letter;

        Letter(String letter, int time) {
            this.letter = letter;
            this.time = time;
        }
    }
}
