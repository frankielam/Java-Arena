package today.lqf.leetcode;

public class LeetCode953 {

    public boolean isAlienSorted(String[] words, String order) {
        int[] arr = new int[26];
        for (int i = 0; i < order.length(); i++) {
            arr[(int) (order.charAt(i) - 'a')] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String s1 = words[i - 1], s2 = words[i];
            for (int j = 0; j < s1.length() && j < s2.length(); j++) {
                int p1 = arr[(int) (s1.charAt(j) - 'a')], p2 = arr[(int) (s2.charAt(j) - 'a')];
                if (p1 < p2) {
                    break;
                }
                if (p1 > p2) {
                    return false;
                }
                if (j == s2.length() - 1 && s1.length() > s2.length()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode953 obj = new LeetCode953();
        System.out.println(obj.isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(obj.isAlienSorted(new String[] { "word", "world", "row" }, "worldabcefghijkmnpqstuvxyz"));
    }

}
