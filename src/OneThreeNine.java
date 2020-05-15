import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lideqing@xiaomi.com on 20-3-25
 */
public class OneThreeNine {
    Set<String> wordsSet = new HashSet<>();
    boolean []dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return false;
        }
        dp = new boolean[s.length()+1];
        dp[0] = true;
        wordsSet.addAll(wordDict);
        for (int i = 1 ; i <= s.length() ; ++i) {
            for (int j = 0 ; j <=i ; ++j) {
                if (dp[j]&&wordsSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }

    public static void main(String[] args) {
        OneThreeNine oneThreeNine = new OneThreeNine();
        String []arr = {"apple", "pen"};
        System.out.println(oneThreeNine.wordBreak("applepenapple", Arrays.asList(arr)));
    }
}
