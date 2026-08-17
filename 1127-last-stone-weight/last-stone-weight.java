class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int i=0; i<stones.length; i++) {
            pq.add(stones[i]);
        }
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if(a == b) {
                continue;
            } else {
                pq.add(a-b);
            }
        }
        return pq.size() == 0? 0 : pq.peek();
    }
}