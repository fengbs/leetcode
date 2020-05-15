

/**
 * Created by lideqing@xiaomi.com on 20-4-9
 */
public class ThreeOneEight {
    public int maxProduct(String[] words) {
        int[] k = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            for (char chara : words[i].toCharArray()) {
                k[i] |= 1 << (chara - 'a');
            }
        }
        int maxLength = 0;
        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                int length = words[i].length() * words[j].length();
                if (length > maxLength && (k[i] & k[j]) == 0) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        ThreeOneEight threeOneEight = new ThreeOneEight();
        String[] input = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(threeOneEight.maxProduct(input));
    }
}
