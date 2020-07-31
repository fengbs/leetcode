/**
 * Created by lideqing@xiaomi.com on 20-6-2
 */
public class ThreeEightSeven {
    int used[] = new int[26];
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        for (char i : s.toCharArray()) {
            used[i-'a']++;
        }
        for (int i = 0 ; i < s.length() ; ++i) {
            if (used[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
