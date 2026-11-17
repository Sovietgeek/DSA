import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        // Quick pruning: minimum possible sum of k distinct numbers is 1 + 2 + ... + k
        // Maximum possible sum of k distinct numbers is 9 + 8 + ... + (10 - k)
        if (n < k * (k + 1) / 2 || n > k * (19 - k) / 2) {
            return result;
        }
        
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int k, int remaining, List<Integer> current, List<List<Integer>> result) {
        // Base case: picked k numbers
        if (current.size() == k) {
            if (remaining == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        // Loop bound pruning: need (k - current.size()) more numbers, so stop early if not enough digits remain
        int needed = k - current.size();
        for (int num = start; num <= 9 - needed + 1; num++) {
            // Since numbers increase, if num > remaining, no subsequent number can work
            if (num > remaining) {
                break;
            }

            current.add(num);
            backtrack(num + 1, k, remaining - num, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}