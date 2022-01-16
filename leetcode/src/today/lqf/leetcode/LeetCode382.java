package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeetCode382 {

    List<Integer> list;

    public LeetCode382(ListNode head) {
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int n = list.size();
        return list.get(new Random().nextInt(n));
    }

    public static void main(String[] args) {
        ListNode next = new ListNode(3);
        ListNode head = new ListNode(2, next);
        next = head;
        head = new ListNode(1, next);
        LeetCode382 obj = new LeetCode382(head);
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}