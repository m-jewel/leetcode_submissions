class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        // Use three variables to keep track of the last three values in the sequence
        int t0 = 0, t1 = 1, t2 = 1;
        int tn = 0;

        for (int i = 3; i <= n; i++) {
            tn = t0 + t1 + t2; // Calculate the next Tribonacci number
            t0 = t1; // Update t0, t1, t2 for the next iteration
            t1 = t2;
            t2 = tn;
        }

        return tn;
    }
}
