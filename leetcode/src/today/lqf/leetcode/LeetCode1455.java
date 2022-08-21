package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 */
public class LeetCode1455 {
    
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str = sentence.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (str[i].indexOf(searchWord) == 0) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode1455 obj = new LeetCode1455();
        System.out.println(obj.isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(obj.isPrefixOfWord("this problem is an easy problem", "pro"));
    }

}
