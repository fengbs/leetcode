package future;

/**
 * Created by lideqing@xiaomi.com on 20-5-20
 */
public class Kmp {
    void GetNextval(char[] p, int next[]) {
        int pLen = p.length;
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pLen - 1) {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || p[j] == p[k]) {
                ++j;
                ++k;
                //较之前next数组求法，改动在下面4行
                //if (p[j] != p[k]) {
                    next[j] = k;   //之前只有这一行
                //} else
                //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                //{
                   // next[j] = next[k];
                //}
            } else {
                k = next[k];
            }
        }
    }

    public static void main(String[] args) {
        Kmp kmp = new Kmp();
        String str = "aaaa";
        int[] arr = new int[str.length()];
        kmp.GetNextval(str.toCharArray(), arr);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
