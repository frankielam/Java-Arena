package today.lqf.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode819 {

    // paragraph 只包含字母、空格和下列标点符号!?',;.
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        
        StringBuffer sb = new StringBuffer();
        paragraph = paragraph.toLowerCase();
        for (int i=0; i<paragraph.length(); i++) {
            if (paragraph.charAt(i) >= 'a' && paragraph.charAt(i) <= 'a' ) {
                sb.append(paragraph.charAt(i));
            } else {
                
                sb = new StringBuffer();
            }
        }

        return "";
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LeetCode819 obj = new LeetCode819();
        System.out.println(
                obj.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] { "hit" }));
    }

}
