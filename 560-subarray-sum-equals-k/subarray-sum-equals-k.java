import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap: Key -> Prefix Sum, Value -> Frequency (woh sum kitni baar aaya)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base Case: 0 sum pehle se 1 baar exist karta hai (khali subarray ke liye)
        map.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentSum += num; // Ab tak ka prefix sum
            
            // Agar (currentSum - k) pehle dikha hai, toh utne valid subarrays mil gaye
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            
            // Current sum ko map mein daalo ya uski frequency badhao
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}