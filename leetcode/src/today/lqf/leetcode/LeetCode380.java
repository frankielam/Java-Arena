package today.lqf.leetcode;
import java.util.HashSet;
import java.util.Set;

public class LeetCode380 {

    Set<Integer> set;
    
    public LeetCode380() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        return set.add(val);
    }
    
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    public int getRandom() {        
        return (int) set.toArray()[(int) (Math.random() * set.size())];
    }
    
    public static void main(String[] args) {
        LeetCode380 obj = new LeetCode380();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.insert(3));
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(4));
        System.out.println(obj.getRandom());
        

    }

}
