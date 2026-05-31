class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int max = 0;
        for (int x : asteroids) {
            max = Math.max(max, x);
        }
        int[] freq = new int[max + 1];
        for (int x : asteroids) {
            freq[x]++;
        }
        long currMass = mass;
        for (int i = 0; i <= max; i++) {
            while (freq[i] > 0) {
                if (currMass < i) {
                    return false;
                }
                currMass += i;
                freq[i]--;
            }
        }
        return true;
    }
}