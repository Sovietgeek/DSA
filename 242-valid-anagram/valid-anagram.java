class Solution {
    public boolean isAnagram(String s, String t) {
        // STEP 1: Length check (Ye tune khud socha tha, mast!)
        if (s.length() != t.length()) {
            return false;
        }
        
        // STEP 2: 26 dabbe (alphabet a-z) ka array banaya
        int[] count = new int[26];
        
        // STEP 3: Ek hi loop mein s ke liye +1 aur t ke liye -1 kar rahe hain
        for (int i = 0; i < s.length(); i++) {
            // SYNTAX TRICK: s.charAt(i) - 'a'
            // Agar char 'a' hai, toh 'a' - 'a' = 0. Index 0 pe +1.
            // Agar char 'c' hai, toh 'c' - 'a' = 2. Index 2 pe +1.
            count[s.charAt(i) - 'a']++; 
            count[t.charAt(i) - 'a']--; 
        }
        
        // STEP 4: Saare dabbo (0 se 25) ko check karo
        for (int i = 0; i < 26; i++) {
            // Agar ek bhi dabba 0 nahi hai, matlab count match nahi kiya
            if (count[i] != 0) {
                return false;
            }
        }
        
        // Agar sab 0 hain, toh perfect anagram hai
        return true;
    }
}