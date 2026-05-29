public class LC_3300_MinimumElement {
     public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int n : nums){
            ans = Math.min(ans,number(n));
        }
        return ans;
    }
    public int number(int n){
        int a = 0;
        while(n>0){
            a += (n%10);
            n /= 10;
        }
        return a;
    }
}