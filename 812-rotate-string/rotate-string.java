class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        // 2. Check karo ki (s + s) ke andar goal majood hai ya nahi
        return (s + s).contains(goal);
    }
}