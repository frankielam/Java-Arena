package today.lqf.leetcode;

public class LeetCode67 {

    public String addBinary(String a, String b) { 
        String max, min;
        if (a.length() > b.length()) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        char[] arr = new char[max.length()+1];
        int idx = 1;
        arr[0] = '0';
        for (char c : max.toCharArray()) {
            arr[idx++] = c;
        }
        
        char tmpC = '0';
        for (int i = arr.length-1, j = min.length()-1; i >= 0; i--, j--) {
            char jC = j>=0?min.charAt(j):'0';
            
            int x =  (arr[i] + jC + tmpC) - (3 * '0'); 
            if (x == 0) {
                arr[i] = '0';
                tmpC = '0';
            } else if (x == 1) {
                arr[i] = '1';
                tmpC = '0';
            } else if (x == 2) {
                arr[i] = '0';
                tmpC = '1'; 
            } else if (x == 3) {
                arr[i] = '1';
                tmpC = '1';
            }
            
        }
        
        System.out.println(new String(arr));
        return arr[0]=='1'?new String(arr):(new String(arr)).substring(1);
    }
    
    
    public static void main(String[] args) {
        LeetCode67 obj = new LeetCode67();
        
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String rst = obj.addBinary(a, b);
//        System.out.println((int)"0".charAt(0));
//        System.out.println((int)"1".charAt(0));
//        String rst = "";
        System.out.println(rst);

    }

}
