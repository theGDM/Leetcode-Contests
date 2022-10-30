//TC : O(NlogN)
class Solution {
    public class Pair implements Comparable<Pair>{
        int view;
        String id;
        
        Pair(int view, String id){
            this.view = view;
            this.id = id;
        }
        
        public int compareTo(Pair o){
            if(this.view != o.view){ //if views are different, then sort Decreasingly
                return o.view - this.view; 
            }else{
                return this.id.compareTo(o.id); //if views are same, then sort lexicographically
            }
        }
    }
    
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Integer> map1 = new HashMap<>(); //creators VS view
        for(int i = 0; i < creators.length; ++i){ //O(N)
            String c = creators[i];
            map1.put(c, map1.getOrDefault(c, 0) + views[i]);
        }
        
        
        HashMap<String, ArrayList<Pair>> map2 = new HashMap<>(); //creators VS (His/Her all videos id's list)
        for(int i = 0; i < creators.length; ++i){ //O(N)
            String c = creators[i];
            if(map2.containsKey(c) == false){
                map2.put(c, new ArrayList<>());
            }
            map2.get(c).add(new Pair(views[i], ids[i])); //store video with id, and with there respective views
        }
        
        List<List<String>> res = new ArrayList<>();
        
        int max = 0;
        for(String key : map1.keySet()){ //finding the maximum views of the creator
            max = Math.max(max, map1.get(key));
        }
        
        for(String key : map1.keySet()){
            if(map1.get(key) == max){
                List<String> p = new ArrayList<>();
                p.add(key);
                Collections.sort(map2.get(key));
                p.add(map2.get(key).get(0).id);
                res.add(p);
            }
        }
        
        return res;
    }
}
