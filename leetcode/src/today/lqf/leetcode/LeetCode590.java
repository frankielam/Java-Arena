package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode590 {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null)
            return list;
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                postorder(root.children.get(i));
            }
        }
        list.add(root.val);
        return list;
    }

    public static void main(String[] args) {
        LeetCode590 obj = new LeetCode590();
//        System.out.println(obj.postorder(null));

    }

}
