class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length(); // 'char' ki jagah 'int' aayega
        int count = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            // Dhyan dein: '' ke beech me space hai -> ' '
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                // Agar space mila AUR humne letters ginn liye hain
                // Matlab last word khatam ho gaya, toh loop rok do.
                if (count > 0) {
                    break;
                }
            }
        }
        
        return count;
    }
}