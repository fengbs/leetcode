/**
 * Created by lideqing@xiaomi.com on 20-5-18
 */
public class OneFour {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return "";
        }
        int i = 0;
        boolean flag = true;
        while (flag) {
            char tem = 'a';
            for (int j = 0; j < strs.length; ++j) {
                if (strs[j].length() > i) {
                    if (j == 0) {
                        tem = strs[j].charAt(i);
                    } else if (tem != strs[j].charAt(i)) {
                        return sb.toString();
                    }
                } else {
                    return sb.toString();
                }

            }
            sb.append(strs[0].charAt(i));
            ++i;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OneFour oneFour = new OneFour();
        String [] input = {"flower","flow","flight"};
        System.out.println(oneFour.longestCommonPrefix(input));
    }

}
