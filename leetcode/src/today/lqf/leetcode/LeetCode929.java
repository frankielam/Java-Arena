package today.lqf.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            boolean name = true, domain = false;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    domain = true;
                } else if (email.charAt(i) == '+') {
                    name = false;
                }

                if (domain) {
                    sb.append(email.charAt(i));
                } else {
                    if (name) {
                        if (email.charAt(i) != '.') {
                            sb.append(email.charAt(i));
                        }
                    }
                }

            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        LeetCode929 obj = new LeetCode929();
        System.out.println(obj.numUniqueEmails(new String[] { "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" }));
    }

}
