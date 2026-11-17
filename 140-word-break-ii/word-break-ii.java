import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        // dp[i] holds all valid sentences for the prefix s[0...i)
        List<List<String>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(""); // Base case: empty prefix

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp.get(j).isEmpty()) {
                    continue;
                }

                String word = s.substring(j, i);
                if (wordSet.contains(word)) {
                    for (String prevSentence : dp.get(j)) {
                        if (prevSentence.isEmpty()) {
                            dp.get(i).add(word);
                        } else {
                            dp.get(i).add(prevSentence + " " + word);
                        }
                    }
                }
            }
        }

        return dp.get(n);
    }
}