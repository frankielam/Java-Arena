package today.lqf.leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 *
 */
public class LeetCode653 {

    Set<Integer> valueSet = new HashSet<>();

    /*
     * 深度优先
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (valueSet.contains(k - root.val)) {
            return true;
        }
        valueSet.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    /*
     * 广度优先
     */
    public boolean findTarget2(TreeNode root, int k) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            root = queue.poll();
            if (valueSet.contains(k - root.val)) {
                return true;
            }

            valueSet.add(root.val);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }

}
