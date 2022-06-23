package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 */
public class LeetCode515 {

    List<Integer> list;

    public List<Integer> largestValues(TreeNode root) {
        list = new ArrayList<>();
        if (root != null) {
            middleSearch(root, 1);
        }
        return list;
    }

    private void middleSearch(TreeNode node, int deep) {
        if (list.size() < deep) {
            list.add(node.val);
        } else {
            if (node.val > list.get(deep - 1)) {
                list.set(deep - 1, node.val);
            }
        }
        if (node.left != null) {
            middleSearch(node.left, deep + 1);
        }
        if (node.right != null) {
            middleSearch(node.right, deep + 1);
        }
    }

    public static void main(String[] args) {
        LeetCode515 obj = new LeetCode515();
    }

}
