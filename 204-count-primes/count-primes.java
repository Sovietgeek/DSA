class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        // isComposite[i] == false means i is prime
        boolean[] isComposite = new boolean[n];

        // Only need to sieve up to sqrt(n)
        for (int i = 2; i * i < n; i++) {
            if (!isComposite[i]) {
                // Start marking multiples from i * i (smaller multiples were already marked)
                for (int j = i * i; j < n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                count++;
            }
        }

        return count;
    }
}