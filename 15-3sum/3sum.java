class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. RESULT LIST: Humey triplets return karni hai, isliye List of List banayi.
        List<List<Integer>> result = new ArrayList<>();
        
        // 2. SORTING: Sabse pehle array sort kar. 
        // KYU? Kyunki Two Pointers (left aur right) tabhi kaam karta hai jab elements order mein hon. 
        // Aur duplicates side-by-side aayenge jinhe skip karna easy hoga.
        Arrays.sort(nums);
        
        // 3. OUTER LOOP: i = 0 se n-3 tak. (n-3 isliye kyunki last ke 2 elements left aur right ke liye chahiye)
        for (int i = 0; i < nums.length - 2; i++) {
            
            // 4. DUPLICATE SKIP FOR 'i': 
            // KYU? Agar nums[i] aur nums[i-1] same hain, toh hum wahi triplet dobara banayenge. 
            // Example: [-1, -1, 0, 1]. Pehle -1 pe triplet ban gaya. Doosre -1 pe bhi same banega. Galti!
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Agar same hai toh is iteration ko skip kar
            }
            
            // 5. TWO POINTERS SET: 
            // left hamesha i ke ek aage hoga. right array ke end pe.
            int left = i + 1;
            int right = nums.length - 1;
            
            // 6. INNER LOOP: Jab tak dono pointers cross nahi karte
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // 7. TRIPLET MIL GAYA! List mein daal de.
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 8. DUPLICATE SKIP FOR 'left':
                    // KYU? Agar left pe same values aate rahenge, toh same triplet banega. 
                    // Example: [-2, 0, 0, 2, 2]. Triplet ban gaya. Ab left++ kiya toh 0 hai, right-- kiya toh 2 hai. Phir same triplet banega.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++; // Jab tak same value hai, aage badh
                    }
                    
                    // 9. DUPLICATE SKIP FOR 'right': Same logic right ke liye.
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--; // Jab tak same value hai, peeche aa
                    }
                    
                    // 10. NEXT UNIQUE ELEMENTS: 
                    // Jab duplicates skip kar liye, toh ab dono pointers ko ek step aage/peeche kar unique elements pe ja.
                    left++;
                    right--;
                    
                } else if (sum < 0) {
                    // 11. SUM CHHOTA HAI: 
                    // KYU? Array sorted hai. Sum 0 tak pahunchne ke liye bada number chahiye. 
                    // Bada number right side hoga, isliye left ko aage badha.
                    left++;
                } else {
                    // 12. SUM BADA HAI: 
                    // KYU? Sum 0 se zyada ho gaya. Chhota number chahiye. 
                    // Chhota number left side hoga, isliye right ko peeche kheench.
                    right--;
                }
            }
        }
        return result; // 13. Saare unique triplets return kar
    }
}