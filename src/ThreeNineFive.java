import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lideqing@xiaomi.com on 20-6-2
 */
public class ThreeNineFive {
    private int k;
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        this.k = k;
        int a[] = new int[26];
        for (char i : s.toCharArray()) {
            a[i - 'a']++;
        }
        Set<Character> list = new HashSet<>();
        for (int i = 0; i < a.length; ++i) {
            if (a[i] != 0) {
                if (a[i] < k) {
                    list.add((char) (i + 'a'));
                }
            }
        }
        if (list.size() == 0) {
            return s.length();
        } else {
            int start = 0;
            int max = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (list.contains(s.charAt(i))) {
                    if (i - start >= k) {
                        int tem = longestSubstring(s.substring(start, i), k);
                        if (tem > max) {
                            max = tem;
                        }
                    }
                    start = i+1;
                }
            }
            if (s.length() - start >= k) {
                int tem = longestSubstring(s.substring(start, s.length()), k);
                if (tem > max) {
                    max = tem;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        ThreeNineFive threeNineFive = new ThreeNineFive();
        System.out.println(threeNineFive.longestSubstring("bbaaacbd",3));
    }
}
