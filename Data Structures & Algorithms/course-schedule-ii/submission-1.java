class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        int[] vis = new int[numCourses];
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i: prerequisites){
            adj.get(i[1]).add(i[0]);
        }

        for(int i=0;i<numCourses;i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.add(i);
        }

        int[] topo = new int[numCourses];
        int index =0;

        while(!q.isEmpty()){
            int node = q.poll();
            topo[index++]=node;

            for(int i: adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0)q.add(i);
            } 
        }


        return index == numCourses ? topo : new int[0];
    }
}
