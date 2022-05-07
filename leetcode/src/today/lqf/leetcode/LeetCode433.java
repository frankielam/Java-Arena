package today.lqf.leetcode;

public class LeetCode433 {

    int len, min;
    int[] change;

    public int minMutation(String start, String end, String[] bank) {
        len = bank.length;
        change = new int[len];
        min = -1;
        recursion(start, end, bank, 0);
        return min;
    }

    private void recursion(String start, String end, String[] bank, int cnt) {
        for (int i = 0; i < len; i++) {
            if (change[i] == 1) {
                continue;
            }
            int diff = 0;
            for (int j = 0; j < start.length(); j++) {
                if (start.charAt(j) != bank[i].charAt(j)) {
                    diff++;
                }
            }
            if (diff == 1) {
                cnt++;
                
                change[i] = 1;
                String tmp = start;
                start = bank[i];
                if (start.equals(end)) {
                    if (min == -1 || cnt < min) {
                        min = cnt;
                    }
                }
                
                recursion(start, end, bank, cnt);

                start = tmp;
                change[i] = 0;
                cnt--;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode433 obj = new LeetCode433();
        System.out.println(obj.minMutation("AACCGGTT", "AACCGGTA", new String[] { "AACCGGTA" }));
        System.out.println(obj.minMutation("AACCGGTT", "AAACGGTA", new String[] { "AACCGGTA", "AACCGCTA", "AAACGGTA" }));
        System.out.println(obj.minMutation("AAAAACCC", "AACCCCCC", new String[] { "AAAACCCC", "AAACCCCC", "AACCCCCC" }));
        System.out.println(obj.minMutation("AAAACCCC", "CCCCCCCC", new String[] { "AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC" }));
    }

}
