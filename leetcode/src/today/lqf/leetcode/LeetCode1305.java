package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode1305 {
    List<Integer> list;

    public void s(TreeNode1305 root) {
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                s(root.left);
            }
            if (root.right != null) {
                s(root.right);
            }
        }
    }

    public List<Integer> getAllElements(TreeNode1305 root1, TreeNode1305 root2) {
        list = new ArrayList<>();
        s(root1);
        s(root2);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        LeetCode1305 obj = new LeetCode1305();
        TreeNode1305 root1 = new TreeNode1305(2, new TreeNode1305(1), new TreeNode1305(4));
        TreeNode1305 root2 = new TreeNode1305(1, new TreeNode1305(0), new TreeNode1305(3));
        System.out.println(obj.getAllElements(root1, root2));

    }

}

class TreeNode1305 {
    int val;
    TreeNode1305 left;
    TreeNode1305 right;

    TreeNode1305() {
    }

    TreeNode1305(int val) {
        this.val = val;
    }

    TreeNode1305(int val, TreeNode1305 left, TreeNode1305 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
