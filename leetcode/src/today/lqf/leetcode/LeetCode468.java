package today.lqf.leetcode;

public class LeetCode468 {

    public String validIPAddress(String queryIP) {
        String[] ipv4 = queryIP.split("\\.", 4);
        if (ipv4.length > 1) {
            if (ipv4.length == 4) {
                for (String path : ipv4) {
                    if (path.length() < 1 || path.length() > 3) {
                        return "Neither";
                    }
                    for (char c : path.toCharArray()) {
                        if (!('0' <= c && c <= '9')) {
                            return "Neither";
                        }
                    }
                    Integer num = Integer.parseInt(path);
                    if (num < 0 || num > 255 || !path.equals(num.toString())) {
                        return "Neither";
                    }
                }
                return "IPv4";
            }
        } else {
            String[] ipv6 = queryIP.toLowerCase().split(":", 8);
            if (ipv6.length == 8) {
                for (String path : ipv6) {
                    if (path.length() < 1 || path.length() > 4) {
                        return "Neither";
                    }
                    for (char c : path.toCharArray()) {
                        if (!('0' <= c && c <= '9') && !('a' <= c && c <= 'f')) {
                            return "Neither";
                        }
                    }
                }
                return "IPv6";
            }
        }
        return "Neither";
    }

    public static void main(String[] args) {
        LeetCode468 obj = new LeetCode468();
        System.out.println(obj.validIPAddress("172.16.254.1"));
        System.out.println(obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(obj.validIPAddress("256.256.256.256"));
        System.out.println(obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));

        System.out.println(obj.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));

    }

}
