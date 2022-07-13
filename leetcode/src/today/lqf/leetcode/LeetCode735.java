package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LeetCode735 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();

        for (int item : asteroids) {
            if (item > 0) {
                left.push(item);
                continue;
            }
            compare(left, right, item);
        }

        List<Integer> list = new ArrayList<>();
        if (!left.empty()) {
            while (!left.empty()) {
                list.add(left.pop());
            }
        }
        if (!right.empty()) {
            while (!right.empty()) {
                list.add(right.pop());
            }
        }
        Collections.reverse(list);
        int[] arr = new int[list.size()];
        arr = list.stream().mapToInt(Integer::valueOf).toArray();
        return arr;
    }

    private void compare(Stack<Integer> left, Stack<Integer> right, int cur) {
        if (left.empty()) {
            right.push(cur);
        } else {
            int other = left.pop();
            if (0 - cur > other) {
                compare(left, right, cur);
            } else if (0 - cur < other) {
                left.push(other);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode735 obj = new LeetCode735();
        System.out.println(Arrays.toString(obj.asteroidCollision(new int[] { -1, -2, 1, 2 })));
    }
}