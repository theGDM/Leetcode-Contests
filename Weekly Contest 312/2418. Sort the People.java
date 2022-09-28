class Solution {
    public class Pair implements Comparable<Pair>{
        String nm;
        int ht;
        
        Pair(String nm, int ht){
            this.nm = nm;
            this.ht = ht;
        }
        
        public int compareTo(Pair o){
            return o.ht - this.ht;
        }
    }
    
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < n; ++i){
            pq.add(new Pair(names[i], heights[i]));
        }
        
        String[] ans = new String[n];
        int idx = 0;
        
        for(int i = 0; i < n; ++i){
            ans[idx++] = pq.remove().nm;
        }
        
        return ans;
    }
}
