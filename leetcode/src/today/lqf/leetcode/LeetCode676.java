package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode676 {

    Map<Integer, List<String>> map;

    public LeetCode676() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            int len = word.length();
            List<String> list = map.getOrDefault(len, new ArrayList<>());
            list.add(word);
            map.put(len, list);
        }
    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        if (!map.containsKey(len)) {
            return false;
        }
        List<String> list = map.get(len);
        for (String word : list) {
            int diff = 0;
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    diff++;
                    if (diff > 1) {
                        break;
                    }
                }
            }
            if (diff == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode676 obj = new LeetCode676();
        obj.buildDict(new String[] {"hello", "hi", "hola"});
        System.out.println(obj.search("hella"));
        System.out.println(obj.search("hey"));
        System.out.println(obj.search("holl"));
        System.out.println(obj.search("holal"));
        
    }

}
