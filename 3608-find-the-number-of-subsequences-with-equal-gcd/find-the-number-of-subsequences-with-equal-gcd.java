class Solution {
    static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        Integer[][][] memo = new Integer[nums.length + 1][max + 1][max + 1];

        return dfs(0, 0, 0, nums, memo);
    }

    private int dfs(int idx, int g1, int g2, int[] nums, Integer[][][] memo) {
        if (idx == nums.length) {
            return (g1 != 0 && g1 == g2) ? 1 : 0;
        }

        if (memo[idx][g1][g2] != null)
            return memo[idx][g1][g2];

        long ans = 0;

        // Skip current element
        ans += dfs(idx + 1, g1, g2, nums, memo);

        // Put current element in first subsequence
        ans += dfs(idx + 1,
                g1 == 0 ? nums[idx] : gcd(g1, nums[idx]),
                g2,
                nums,
                memo);

        // Put current element in second subsequence
        ans += dfs(idx + 1,
                g1,
                g2 == 0 ? nums[idx] : gcd(g2, nums[idx]),
                nums,
                memo);

        memo[idx][g1][g2] = (int) (ans % MOD);
        return memo[idx][g1][g2];
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}