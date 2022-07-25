package today.lqf.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.cn/problems/complete-binary-tree-inserter/
 */
public class LeetCode919 {

    TreeNode root;
    Queue<TreeNode> queue;

    public LeetCode919(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.peek() != null) {
            TreeNode node = q.poll();
            if (node.right == null) {
                queue.offer(node);
            }
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
    }

    public int insert(int val) {
        TreeNode parent = queue.element();
        TreeNode node = new TreeNode(val);
        if (parent.left == null) {
            parent.left = node;
            queue.offer(parent.left);
        } else {
            parent.right = node;
            queue.poll();
            queue.offer(parent.right);
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        LeetCode919 obj = new LeetCode919(new TreeNode(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.insert(3));
        System.out.println(obj.insert(4));
        System.out.println(obj.insert(5));
        System.out.println(obj.get_root());
    }

}
