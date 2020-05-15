/**
 * Created by lideqing@xiaomi.com on 20-5-9
 */
public class ThreeOneSix {
    public String removeDuplicateLetters(String s) {
        int a[] = new int[26];
        boolean used[] = new boolean[26];
        for (char i : s.toCharArray()) {
            a[i - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char i : s.toCharArray()) {
            a[i - 'a']--;
            if (used[i - 'a']) {
                continue;
            }
            while (sb.length() != 0
                && sb.charAt(sb.length() - 1) > i
                && a[sb.charAt(sb.length() - 1) - 'a'] != 0) {
                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);

            }
            sb.append(i);
            used[i - 'a'] = true;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ThreeOneSix threeOneSix = new ThreeOneSix();
        System.out.println(threeOneSix.removeDuplicateLetters("cbacdcbc"));
    }
}
