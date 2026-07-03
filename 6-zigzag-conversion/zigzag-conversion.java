class Solution {
    public String convert(String s, int numRows) {
        // Edge Case: Agar numRows 1 hai ya string ki length numRows se kam hai,
        // toh zigzag pattern banane ki koi zaroorat nahi hai.
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Har row ke liye ek StringBuilder create karenge
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // String ke har character ko sahi row mein append karenge
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Agar hum pehli row ya aakhri row par hain, toh direction change hogi
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Direction ke mutabik currentRow ko badhayein ya ghatayein
            currentRow += goingDown ? 1 : -1;
        }

        // Saari rows ko aapas mein jod kar final result banayein
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}