class Solution {
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis,int[] pathVis){

        vis[node]=1;
        pathVis[node]=1;
        for(int i : adj.get(node)){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathVis))return true;
            }
            else if(pathVis[i]==1){
                return true;
            }
        }
        pathVis[node]=0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();

        for(int i=0;i<numCourses ;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] j: prerequisites){
            adj.get(j[1]).add(j[0]);
        }

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0)if(dfs(i,adj,vis,pathVis))return false;
        }
        return true;

    }
}
