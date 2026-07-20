class Solution {
    public String reverseWords(String s) {
        // 1. Leading/trailing spaces hatao aur 1 ya 1 se zyada spaces par split karo
        String[] words = s.trim().split("\\s+");
        
        // 2. Two Pointers: First aur Last word ke liye
        int i = 0;
        int j = words.length - 1;
        
        // 3. Words ko swap karein
        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            
            i++;
            j--;
        }
        
        // 4. Swapped words ko single space se connect karke return karein
        return String.join(" ", words);
    }
}