public class Solution {
    // Using dynamic programming
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n]; // result array (default 0 for days with no warmer future)

        // Start from the second‑to‑last day and move leftwards
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1; // initial candidate: the next day

            // Keep jumping forward until we find a warmer day or know none exists
            while (j < n && temperatures[j] <= temperatures[i]) {
                // If day j has no warmer day in its future,
                // then day i cannot have a warmer day either
                // (because any warmer day for i would also be warmer for j).
                if (res[j] == 0) {
                    break; // exit the while loop → j will remain < n? Actually j is still <= temperatures[i]
                }
                // Otherwise, jump directly to the next candidate after j's warmer day
                j += res[j];
            }

            // After the loop, check if we found a warmer day
            if (j < n && temperatures[j] > temperatures[i]) {
                res[i] = j - i; // distance in days
            }
            // else res[i] stays 0 (no warmer day)
        }
        return res;
    }
}