class Solution {
    public int minimumCost(int[] cost) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : cost){
            pq.offer(a);
        }
        while(!pq.isEmpty()){
            if (!pq.isEmpty()) ans += pq.poll(); // buy
            if (!pq.isEmpty()) ans += pq.poll(); // buy
            if (!pq.isEmpty()) pq.poll(); // free candy
        }
        return ans;

    }
}