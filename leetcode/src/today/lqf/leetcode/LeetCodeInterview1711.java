package today.lqf.leetcode;

public class LeetCodeInterview1711 {

    public int findClosest(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        for (int i = 0, p1 = -1, p2 = -1; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (words[i].equals(word1)) {
                    p1 = i;
                } else {
                    p2 = i;
                }
                if (p1 != -1 && p2 != -1) {
                    min = Math.min(Math.abs(p1 - p2), min);
                    if (min == 1) {
                        return min;
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCodeInterview1711 obj = new LeetCodeInterview1711();
        System.out.println(obj.findClosest(
                new String[] { "I", "am", "a", "student", "from", "a", "university", "in", "a", "city" }, "a",
                "student"));
    }

}
