package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode429 {

    public List<List<Integer>> levelOrderBefore(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        List<Integer> subList = new ArrayList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                if (subList.size() > 0) {
                    list.add(subList);
                }
                subList = new ArrayList<>();
            } else {
                subList.add(node.val);

                List<Node> childs = node.children;
                if (childs.size() > 0) {
                    for (Node child : childs) {
                        queue.add(child);
                    }
                }
                if (queue.size() > 0 && queue.element() == null) {
                    queue.add(null);
                }
            }
        }
        if (subList.size() > 0) {
            list.add(subList);
        }
        return list;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                subList.add(node.val);
                List<Node> childs = node.children;
                for (Node child : childs) {
                    queue.add(child);
                }
            }
            list.add(subList);
        }

        return list;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

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