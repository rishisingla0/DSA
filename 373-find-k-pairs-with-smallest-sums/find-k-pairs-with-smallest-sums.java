class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i=0; i<Math.min(nums1.length, k); i++) {
            pq.add(new int[] {nums1[i]+nums2[0], i, 0});
        }
        
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<k; i++) {
            int[] curr = pq.poll();
            list.add(Arrays.asList(nums1[curr[1]], nums2[curr[2]]));
            if(curr[2]+1 < nums2.length) {
                curr[2]++;
                pq.add(new int[]{nums1[curr[1]] + nums2[curr[2]], curr[1], curr[2]});
            }
        }
        return list;
    }
}