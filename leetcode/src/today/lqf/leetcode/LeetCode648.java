package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.cn/problems/replace-words/
 */
public class LeetCode648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary, (a, b) -> {
            return a.length() - b.length();
        });

        String[] arr = sentence.split(" ");
        int min = dictionary.get(0).length();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() < min)
                continue;
            for (String dic : dictionary) {
                if (dic.length() > arr[i].length()) {
                    break;
                }
                if (arr[i].indexOf(dic) == 0) {
                    arr[i] = dic;
                    break;
                }
            }
        }
        return String.join(" ", arr);
    }

    public static void main(String[] args) {
        LeetCode648 obj = new LeetCode648();
        System.out.println(obj.replaceWords(Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery"));       
                
    }

}
