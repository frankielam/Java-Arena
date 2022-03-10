package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode589 {

    private void dfs(Node node) {
        if (node != null) {
            list.add(node.val);

            if (node.children != null) {
                for (int i = 0; i < node.children.size(); i++) {
                    dfs(node.children.get(i));
                }
            }
        }
    }

    List<Integer> list;

    public List<Integer> preorder(Node root) {
        list = new ArrayList<>();
        dfs(root);
        return list;

    }

    public static void main(String[] args) {
        LeetCode589 obj = new LeetCode589();
    }

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

}
