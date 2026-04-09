class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visit = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for(int i=0; i<numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int c){
        
        if(visit.contains(c)){
            //cycle detected
            return false;
        }
        if(preMap.get(c).isEmpty()){
            return true;
        }

        visit.add(c);
        for(int pre : preMap.get(c)){
            if(!dfs(pre)){
                return false;
            }
        }
        visit.remove(c);
        preMap.put(c, new ArrayList<>());
        return true;
    }
}