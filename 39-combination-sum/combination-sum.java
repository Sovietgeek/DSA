import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {
        // Base case: target achieve ho gaya
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Base case: array ke end tak pahunch gaye
        if (index == candidates.length) {
            return;
        }

        // 1. Current element ko pick karein (agar target se chhota ya barabar hai)
        if (candidates[index] <= target) {
            current.add(candidates[index]);
            // Same index pass kar rahe hain kyunki element repeat ho sakta hai
            backtrack(index, candidates, target - candidates[index], current, result);
            // Backtrack: last added element hatayein
            current.remove(current.size() - 1);
        }

        // 2. Current element ko skip karein aur next index par jayein
        backtrack(index + 1, candidates, target, current, result);
    }
}