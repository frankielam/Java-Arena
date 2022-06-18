package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.cn/problems/most-frequent-subtree-sum/
 */
public class LeetCode508 {

    Map<Integer, Integer>  map;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        cal(root);
        
        List<Integer> list = new ArrayList<>();
        
        int max = 0;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                list = new ArrayList<>();
                list.add(item.getKey());
            } else if (item.getValue() == max){
                list.add(item.getKey());
            }
        }
        
        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
        return arr;
    }

    private int cal(TreeNode node) {
        if (node == null) 
            return 0;
        int total = node.val + cal(node.left) + cal(node.right);
        int cnt = map.getOrDefault(total, 0);
        map.put(total, ++cnt);
        return total;
    }
    
    public static void main(String[] args) {
        LeetCode508 obj = new LeetCode508();

    }

}
