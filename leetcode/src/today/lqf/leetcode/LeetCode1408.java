package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1408 {

    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        Arrays.sort(words, (a, b) -> {
            return a.length() - b.length();
        });
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].indexOf(words[i]) >= 0) {
                    list.add(words[i]);
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode1408 obj = new LeetCode1408();
        System.out.println(obj.stringMatching(new String[] { "mass","as","hero","superhero" }));

    }

}
