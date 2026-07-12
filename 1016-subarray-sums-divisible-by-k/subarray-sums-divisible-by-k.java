class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Array of size K to store frequency of remainders
        // Index = Remainder, Value = Frequency
        int[] freq = new int[k]; 
        
        // Khali subarray ka remainder 0 hai, wo 1 baar dekh liya
        freq[0] = 1; 
        
        int prefixSum = 0;
        int count = 0;
        
        for (int num : nums) {
            prefixSum += num;
            
            // Remainder nikalo (Negative bachne ka formula)
            int rem = (prefixSum % k + k) % k;
            
            // Count badhao jo pehle se freq[rem] mein hai
            count += freq[rem];
            
            // Frequency update karo
            freq[rem]++; 
        }
        
        return count;
    }
}