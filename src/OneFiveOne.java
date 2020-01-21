/**
 * Created by lideqing@xiaomi.com on 19-12-5
 */
public class OneFiveOne {
    public String reverseWords(String s) {
        if (s == null) {
            return "";
        }
        String []arr = s.trim().split(" ");
        if (arr.length>0) {
            StringBuilder sb = new StringBuilder();
            sb.append(arr[arr.length-1]);
            for (int i = arr.length-2 ; i >= 0 ; --i) {
                String res = arr[i].trim();
                if (!"".equals(res)) {
                    sb.append(" ");
                    sb.append(res);
                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    public static void main (String []args) {
        OneFiveOne oneFiveOne = new OneFiveOne();
        System.out.println(oneFiveOne.reverseWords("a good   example").replace(" ","#"));
    }
}
