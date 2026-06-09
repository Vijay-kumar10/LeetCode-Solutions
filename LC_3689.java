public class LC_3689{
     public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int a : nums){
            max = Math.max(a,max);
            min = Math.min(a,min);
        }
        long ans = (long)(max-min)*k;
        return ans;
    }
}