package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/design-circular-deque/
 */
public class LeetCode641 {

    int[] queue;
    int cnt = 0, len = 0;
    int front = 0, rear = 1;

    public LeetCode641(int k) {
        queue = new int[k];
        len = k;
    }

    public boolean insertFront(int value) {
        if (cnt == len) {
            return false;
        }
        queue[front] = value;
        front--;
        if (front == -1) {
            front = len - 1;
        }
        cnt++;
        return true;
    }

    public boolean insertLast(int value) {
        if (cnt == len) {
            return false;
        }
        queue[rear] = value;
        rear++;
        if (rear == len) {
            rear = 0;
        }
        cnt++;
        return true;
    }

    public boolean deleteFront() {
        if (cnt == 0) {
            return false;
        }
        front++;
        if (front == len) {
            front = 0;
        }
        cnt--;
        return true;
    }

    public boolean deleteLast() {
        if (cnt == 0) {
            return false;
        }
        rear--;
        if (rear == -1) {
            rear = len - 1;
        }
        cnt--;
        return true;
    }

    public int getFront() {
        if (cnt == 0) {
            return -1;
        }
        int ans = queue[front + 1 == len ? 0 : front + 1];
        return ans;
    }

    public int getRear() {
        if (cnt == 0) {
            return -1;
        }
        int ans = queue[rear - 1 == -1 ? len - 1 : rear - 1];
        return ans;
    }

    public boolean isEmpty() {
        if (cnt == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (cnt > 0 && cnt == len) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode641 obj = new LeetCode641(3);
        System.out.println(obj.insertLast(1));
        System.out.println(obj.insertLast(2));
        System.out.println(obj.insertFront(3));
        System.out.println(obj.insertFront(4));
        System.out.println(obj.getRear());
        System.out.println(obj.isFull());
        System.out.println(obj.deleteLast());
        System.out.println(obj.insertFront(3));
        System.out.println(obj.getFront());

    }

}
