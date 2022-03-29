package today.lqf.leetcode;

/**
 * 
 * https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/
 *
 */
public class LeetCode2024 {
    
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(calculate(answerKey, k, 'T'), calculate(answerKey, k, 'F'));
    }

    private int calculate(String answerKey, int k, char c) {
        int len = answerKey.length();
        int max = 0;
        for (int l = 0, r = 0, total = 0; r < len; r++) {
            if (answerKey.charAt(r) != c) {
                total++;
            }
            while (total > k) {
                if (answerKey.charAt(l++) != c) {
                    total--;
                }
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        LeetCode2024 obj = new LeetCode2024();
        System.out.println(obj.maxConsecutiveAnswers("TTFF", 2));
        System.out.println(obj.maxConsecutiveAnswers("TFFT", 1));
        System.out.println(obj.maxConsecutiveAnswers("TTFTTFTT", 1));
        System.out.println(obj.maxConsecutiveAnswers(
                "FFTFTTTFFTTTTFTTFFTFTTFTFTTFFFTTTTFFFTFFFFTTFTFTTFFFFTFTFTFTTFFTFFTFFFFFFTTFFTFFTFFTFFFFFTFTTFFTTFTT",
                10));
    }

}
