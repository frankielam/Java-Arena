package today.lqf.leetcode;

public class LeetCode744 {
    
    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1] || target < letters[0]) {
            return letters[0];
        }
        int l = 0, r = letters.length - 1;
        int m = 0;
        for (; l < r;) {
            m = l + (r - l) / 2;
            if (m == l) {
                break;
            }
            if (letters[m] <= target) {
                l = m;
            } else {
                r = m;
            }
        }
        return letters[m + 1];
    }

    public static void main(String[] args) {
        LeetCode744 obj = new LeetCode744();
        System.out.println(obj.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'a'));
        System.out.println(obj.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'c'));
        System.out.println(obj.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'd'));
        System.out.println(obj.nextGreatestLetter(new char[] {'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e'));

    }

}
