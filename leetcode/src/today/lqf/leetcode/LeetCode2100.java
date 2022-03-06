package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/
 *
 */
public class LeetCode2100 {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> list = new ArrayList<>();

        int len = security.length;
        if (len < 2 * time + 1)
            return list;

        List<Integer> preList = new ArrayList<>();
        List<Integer> suffixList = new ArrayList<>();
        int preTotal = 0, suffixTotal = 0;

        for (int i = 1; i < time && i < len; i++) {
            if (security[i - 1] >= security[i]) {
                // 一开始使用位移实现，当 time 值过大时，如 10000， Math.pow(2, 10000) 的值过大导致结果出错
                preList.add(1);
                preTotal++;
            } else {
                preList.add(0);
            }
        }
        for (int i = 1, j = time; i < time && j < len - 1; i++, j++) {
            if (security[j] <= security[j + 1]) {
                suffixList.add(1);
                suffixTotal++;
            } else {
                suffixList.add(0);
            }
        }

//        System.out.println(preTotal);
//        System.out.println(suffixTotal);
//        System.out.println(time);
//        System.out.println("=======");
        
        for (int i = time, j = 2 * time - 1; i < len - time; i++, j++) {
            if (time == 0) {
                list.add(i);
                continue;
            }
            
            if (preList.size() == time) {
                preTotal = preTotal - preList.get(0);
                preList.remove(0);
                suffixTotal = suffixTotal - suffixList.get(0);
                suffixList.remove(0);  
            } 
            
            if (security[i - 1] >= security[i]) {
                preList.add(1);
                preTotal++;
            } else {
                preList.add(0);
            }
            
            if (security[j] <= security[j + 1]) {
                suffixList.add(1);
                suffixTotal++;
            } else {
                suffixList.add(0);
            }
            
            if (preTotal == time && suffixTotal == time)
                list.add(i);

//            System.out.println(Integer.toBinaryString(pre));
//            System.out.println(Integer.toBinaryString(suffix));
//            System.out.println(Integer.toBinaryString(max));
//            System.out.println(i + "\n");
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode2100 obj = new LeetCode2100();

        System.out.println(obj.goodDaysToRobBank(new int[] { 1, 2, 5, 4, 1, 0, 2, 4, 5, 3, 1, 2, 4, 3, 2, 4, 8 }, 2));
        System.out.println(obj.goodDaysToRobBank(new int[] { 5, 3, 3, 3, 5, 6, 2 }, 2));
        System.out.println(obj.goodDaysToRobBank(new int[] { 1, 1, 1, 1, 1, 1 }, 0));
        System.out.println(obj.goodDaysToRobBank(new int[] { 1, 2, 3, 4, 5, 6 }, 2));
        System.out.println(obj.goodDaysToRobBank(new int[] { 1 }, 5));
        System.out.println(obj.goodDaysToRobBank(new int[] { 1, 2, 3, 4 }, 0));
    }
}
