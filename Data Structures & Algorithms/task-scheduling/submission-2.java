class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int maxFreq = 0;
        for (char t : tasks) {
            counts[t - 'A']++;
            maxFreq = Math.max(maxFreq, counts[t - 'A']);
        }

        // How many tasks have the same maximum frequency?
        int maxFreqCount = 0;
        for (int count : counts) {
            if (count == maxFreq) maxFreqCount++;
        }

        // Formula logic:
        // (maxFreq - 1) is the number of "blocks" before the last instance of the max tasks
        // (n + 1) is the size of each block (the task itself + the cooldown)
        // maxFreqCount is the number of tasks that will occupy the very last spots
        int result = (maxFreq - 1) * (n + 1) + maxFreqCount;

        // The result can't be smaller than the actual number of tasks
        return Math.max(result, tasks.length);
    }
}