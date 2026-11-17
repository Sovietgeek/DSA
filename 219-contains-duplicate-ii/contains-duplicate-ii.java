import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // If add() returns false, nums[i] already exists within the last k elements
            if (!window.add(nums[i])) {
                return true;
            }

            // Keep the sliding window size bounded to at most k elements
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }
}