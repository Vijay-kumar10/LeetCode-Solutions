public class LC_3753 {
 static class Pair {
        long count;
        long waviness;

        Pair(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }

    private String num;
    private Pair[][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) return 0;

        num = String.valueOf(n);
        int len = num.length();

        memo = new Pair[len][2][2][11][11];

        return dfs(0, 1, 0, 10, 10).waviness;
    }

    private Pair dfs(int pos, int tight, int started, int prev2, int prev1) {

        if (pos == num.length()) {
            return new Pair(1, 0);
        }

        if (memo[pos][tight][started][prev2][prev1] != null) {
            return memo[pos][tight][started][prev2][prev1];
        }

        long totalCount = 0;
        long totalWaviness = 0;

        int limit = tight == 1 ? num.charAt(pos) - '0' : 9;

        for (int d = 0; d <= limit; d++) {

            int nextTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                Pair child = dfs(pos + 1, nextTight, 0, 10, 10);

                totalCount += child.count;
                totalWaviness += child.waviness;

            } else {

                int nextStarted = 1;

                if (prev1 == 10) {

                    Pair child =
                            dfs(pos + 1, nextTight, nextStarted, 10, d);

                    totalCount += child.count;
                    totalWaviness += child.waviness;

                } else if (prev2 == 10) {

                    Pair child =
                            dfs(pos + 1, nextTight, nextStarted, prev1, d);

                    totalCount += child.count;
                    totalWaviness += child.waviness;

                } else {

                    int add = 0;

                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = 1;
                    }

                    Pair child =
                            dfs(pos + 1, nextTight, nextStarted, prev1, d);

                    totalCount += child.count;
                    totalWaviness += child.waviness + child.count * add;
                }
            }
        }

        return memo[pos][tight][started][prev2][prev1]
                = new Pair(totalCount, totalWaviness);
    }   
}
