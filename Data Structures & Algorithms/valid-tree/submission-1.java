class Solution {
    public boolean dfs(int[] vis, int parent, ArrayList<ArrayList<Integer>> adj, int node){
        vis[node]=1;

        for(int it: adj.get(node)){
            if(vis[it]==0){
                if(dfs(vis, node,adj,it))return true;
            }
            else if(it!=parent)return true;
        }

        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] it: edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        
        int[] vis = new int[n];
        int parent =-1;

        if(dfs(vis, parent, adj, 0)) return false;

        for(int i = 0; i < n; i++){
            if(vis[i] == 0) return false;
        }

        return true;
    }
}
