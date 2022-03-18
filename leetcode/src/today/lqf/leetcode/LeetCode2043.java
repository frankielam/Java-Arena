package today.lqf.leetcode;

/**
 * 
 * https://leetcode-cn.com/problems/simple-bank-system/
 *
 */
public class LeetCode2043 {

    long[] balance;
    int n = 0;

    public LeetCode2043(long[] balance) {
        this.balance = balance;
        n = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > n || account2 > n || balance[account1 - 1] < money)
            return false;
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > n)
            return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > n || balance[account - 1] < money)
            return false;
        balance[account - 1] -= money;
        return true;
    }

    public static void main(String[] args) {
        

    }

}
