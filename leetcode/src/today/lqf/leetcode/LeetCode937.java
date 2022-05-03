package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
 * https://leetcode-cn.com/problems/reorder-data-in-log-files/
 */
public class LeetCode937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> numList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        for (String log : logs) {
            char lastChar = log.charAt(log.length() - 1);
            if (lastChar >= '0' && lastChar <= '9') {
                numList.add(log);
            } else {
                int idx = 1;
                while (true) {
                    if (log.charAt(idx) == ' ') {
                        break;
                    }
                    idx++;
                }

                strList.add(log.substring(idx + 1) + "," + log.substring(0, idx + 1));

            }
        }
        System.out.println(numList);
        System.out.println(strList);

        Collections.sort(strList, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(",");
                String[] s2 = o2.split(",");
                if (s1[0].equals(s2[0])) {
                    return s1[1].compareTo(s2[1]);
                }
                return s1[0].compareTo(s2[0]);
            }
        });
        System.out.println(strList);

        String[] arr = new String[logs.length];
        int i = 0;
        for (String log : strList) {
            String[] strs = log.split(",");
            arr[i++] = strs[1] + strs[0];
        }
        for (String log : numList) {
            arr[i++] = log;
        }

        return arr;
    }

    public static void main(String[] args) {
        LeetCode937 obj = new LeetCode937();
        System.out.println(Arrays.toString(obj.reorderLogFiles(
                new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" })));
        System.out.println(Arrays.toString(obj.reorderLogFiles(new String[] { "dig1 8 1 5 1", "let1 art zero can",
                "dig2 3 6", "let2 own kit dig", "let3 art zero" })));

    }

}
