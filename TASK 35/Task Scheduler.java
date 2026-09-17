class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int maxFreq = 0;
        int countMax = 0;

        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
                countMax = 1;
            } else if (f == maxFreq) {
                countMax++;
            }
        }

        int result = (maxFreq - 1) * (n + 1) + countMax;

        return Math.max(result, tasks.length);
    }
}
