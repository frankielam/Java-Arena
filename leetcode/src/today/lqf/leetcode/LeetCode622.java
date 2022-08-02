package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/design-circular-queue/
 */
public class LeetCode622 {

    int[] arr;
    int len = 0, size = 0;
    int idx = 0, first = 0;

    public LeetCode622(int k) {
        len = k;
        arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = -1;
        }
    }

    public boolean enQueue(int value) {
        if (size == len) {
            return false;
        }
        while (true) {
            if (idx == len) {
                idx = 0;
            }
            if (arr[idx] == -1) {
                arr[idx++] = value;
                break;
            } else {
                idx++;
            }
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        arr[first++] = -1;
        if (first == len) {
            first = 0;
        }
        size--;
        return true;
    }

    public int Front() {
        return arr[first];
    }

    public int Rear() {
        return arr[idx == 0 ? len - 1 : idx - 1];
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (size == len) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode622 obj = new LeetCode622(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
        System.out.println(obj.isFull());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
//        [null, true, true, true, false, 3, true, true, true, 4]
    }
}
