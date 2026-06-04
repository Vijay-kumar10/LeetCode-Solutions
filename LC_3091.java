public class LC_3091 {
    public int minOperations(int k) {
        int ans = Integer.MAX_VALUE;
        for (int x = 1; x <= k; x++) {
            int n = (k + x - 1) / x; // ceil(k / x)
            ans = Math.min(ans, (x - 1) + (n - 1));
        }
        return ans;
    }
}
