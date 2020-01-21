/**
 * Created by lideqing@xiaomi.com on 19-12-4
 */
public class OneSixFive {

    public int compareVersion(String version1, String version2) {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");
        return version2Arr.length > version1Arr.length?
            0-compareVersion(version2Arr,version1Arr)
            :compareVersion(version1Arr,version2Arr);
    }

    private int compareVersion(String[] version1, String[] version2) {
        for (int i = 0; i < version2.length; ++i) {
            int a = Integer.parseInt(version1[i]);
            int b = Integer.parseInt(version2[i]);
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }
        for (int i = version2.length; i < version1.length; ++i) {
            int a = Integer.parseInt(version1[i]);
            if (a>0) {
                return 1;
            }
        }
        return 0;
    }

    public static void main (String []args) {
        OneSixFive oneSixFive = new OneSixFive();
        System.out.println(oneSixFive.compareVersion("1.1.1","1.1"));
    }
}
