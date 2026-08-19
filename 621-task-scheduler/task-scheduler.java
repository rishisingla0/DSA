class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) +1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(char ch : map.keySet()) {
            pq.add(new int[]{ch, map.get(ch)});
        }

        Queue<int[]> cooldown = new LinkedList<>();
        int currentTime = 0;

        while(!pq.isEmpty() || !cooldown.isEmpty()) {
            if(pq.isEmpty() && !cooldown.isEmpty()) {
                currentTime = cooldown.peek()[2];
            }
            while(!cooldown.isEmpty() && cooldown.peek()[2] <=currentTime) {
                int task[] = cooldown.poll();
                pq.add(new int[]{task[0], task[1]});
            }

            if(!pq.isEmpty()) {
                int[] curr = pq.poll();
                curr[1]--;

                if(curr[1] > 0) {
                    cooldown.add(new int[]{curr[0], curr[1], currentTime+n+1});
                }
            }
            currentTime++;
        }
        return currentTime;
    }
}