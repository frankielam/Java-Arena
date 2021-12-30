package today.lqf.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if (len < groupSize || len % groupSize != 0)
            return false;
        if (groupSize == 1)
            return true;

        Arrays.sort(hand);
        System.out.println(Arrays.toString(hand));
        Stack<Integer> stack = new Stack<>(); // offer peek poll
        Stack<Integer> stack2 = new Stack<>();

        for (int i = hand.length - 1; i >= 0; i--) {
            stack.add(hand[i]);
        }

        int counter = 0, pre = -1;
        while (stack.size() > 0) {
            int element = stack.pop();
            if (pre == -1) {
                pre = element;
                counter++;
                System.out.print(pre + ", ");
                continue;
            }

            if (pre + 1 == element) {
                
                pre = element;
                counter++;
                System.out.print(pre + ", ");
                if (counter == groupSize) {
                    counter = 0;
                    pre = -1;
                    while (!stack2.empty()) {
                        stack.add(stack2.pop());
                    }
                    System.out.println();
                }
            } else  {
                stack2.add(element);
            }
        }
        while (!stack2.empty()) {
            if (pre == -1) {
                pre = stack2.pop();
                counter++;
                System.out.print(pre + ", ");
                continue;
            }
            if (pre + 1 != stack2.pop()) {
                return false;
            } else {
                pre++;
            }
            System.out.print(pre + ", ");
            if (counter == groupSize) {
                counter = 0;
                pre = -1;
            }
        }
        System.out.println(Arrays.toString( stack2.toArray()));
        return true;
    }

    public static void main(String[] args) {
        LeetCode846 obj = new LeetCode846();
        int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        int[] hand2 = { 34, 80, 89, 15, 38, 69, 19, 17, 97, 98, 26, 77, 8, 31, 79, 70, 103, 3, 13, 21, 81, 53, 33, 14,
                60, 68, 33, 59, 84, 23, 97, 90, 76, 82, 66, 83, 23, 22, 16, 18, 98, 25, 16, 61, 84, 100, 4, 68, 101, 25,
                23, 9, 10, 55, 2, 67, 39, 52, 102, 99, 40, 11, 83, 24, 81, 53, 96, 23, 13, 24, 99, 67, 22, 51, 31, 58,
                78, 88, 5, 15, 24, 32, 81, 91, 96, 16, 54, 22, 56, 69, 14, 82, 32, 34, 83, 24, 37, 82, 54, 21 };
        int groupSize = 4;
        boolean rst = obj.isNStraightHand(hand2, groupSize);
        System.out.println(rst);

    }

}
