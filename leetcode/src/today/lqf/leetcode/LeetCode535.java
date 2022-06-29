package today.lqf.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/encode-and-decode-tinyurl/
 * Hash
 */
public class LeetCode535 {

    Map<String, String> map = new HashMap<>();
    String preffix = "http://tinyurl.com/";
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String str = String.valueOf(longUrl.toCharArray().hashCode());
//        System.out.println(longUrl.toCharArray().hashCode());
        
        map.put(str, longUrl);
        return preffix + str;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return  map.getOrDefault(shortUrl.substring(preffix.length()), "");
    }
    
    public static void main(String[] args) {
        LeetCode535 obj = new LeetCode535();
        String url = "https://leetcode.com/problems/design-tinyurl";
//        System.out.println(obj.encode(url));
        System.out.println(obj.decode(obj.encode(url)));
         url = "https://leetcode.com/problems/design-tinyurl2";
//      System.out.println(obj.encode(url));
      System.out.println(obj.decode(obj.encode(url)));

    }

}
