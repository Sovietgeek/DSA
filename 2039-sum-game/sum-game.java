class Solution {
    public boolean sumGame(String num) {
        double res = 0;
        int n = num.length();

        for (int i = 0; i < n; i++) {
            // Left half me add karo, Right half me subtract karo
            int sign = (i < n / 2) ? 1 : -1;

            if (num.charAt(i) == '?') {
                res += sign * 4.5; // Every '?' is worth 4.5 average points
            } else {
                res += sign * (num.charAt(i) - '0');
            }
        }

        // Agar net sum 0 hai toh Bob jeetega (false), aksar Alice jeetegi (true)
        return res != 0;
    }
}