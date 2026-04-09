class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        int component = 0;

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for(int i=0; i<n; i++){
            if(!visit.contains(i)){
                dfs(i, adj, visit);
                component++;
            }
        }

        return component;
    }

    private void dfs(int node, List<List<Integer>> adj, Set<Integer> visit){
        visit.add(node);

        for(int nei : adj.get(node)){
            if(!visit.contains(nei)) {
                dfs(nei, adj, visit);
            }
        }
    }
}

