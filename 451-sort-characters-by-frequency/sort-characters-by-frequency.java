class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) +1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(char c : map.keySet()) {
            pq.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<map.size(); i++) {
            char c = pq.poll();
            int freq = map.get(c);
            while(freq > 0) {
                sb.append(c);
                freq--;
            }
        }
        return sb.toString();
    }
}