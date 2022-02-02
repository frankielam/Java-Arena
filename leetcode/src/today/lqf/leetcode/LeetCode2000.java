package today.lqf.leetcode;

public class LeetCode2000 {

    public String reversePrefix(String word, char ch) {
        char[] arr = new char[word.length()];
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (ch == word.charAt(i) && idx == -1) {
                idx = i;
            }
            arr[i] = word.charAt(i);
        }
        if (idx > 0) {
            for (int i = 0; i <= idx / 2; i++) {
                char tmp = arr[i];
                arr[i] = arr[idx - i];
                arr[idx - i] = tmp;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        LeetCode2000 obj = new LeetCode2000();
        System.out.println(obj.reversePrefix("abcdefd", 'd'));
        System.out.println(obj.reversePrefix("xyxzxe", 'z'));
        System.out.println(obj.reversePrefix("abcd", 'z'));
    }

}
