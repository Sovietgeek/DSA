class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            // Rule 1: Invalid char skip karo
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            // Rule 2 & 3: Compare karo, mismatch par false
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }

        // Rule 4: Sab match ho gaya
        return true;
    }
}