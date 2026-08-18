class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(char ch : map.keySet()) {
            pq.add(new int[] {(int)ch, map.get(ch)});
        }
        StringBuilder sb = new StringBuilder();
        int[] prev = null;
        for(int i=0; i<s.length(); i++) {
            int[] curr = pq.poll();
            if (curr == null) {
                return "";
            } 
            if(curr[1] > 0) {
                sb.append((char)curr[0]);
                curr[1]--;
            }
            if(prev != null && prev[1] > 0) {
                pq.add(prev);
            }
            prev = curr;
        }
        String ans = sb.toString();
        return ans;
    }
}