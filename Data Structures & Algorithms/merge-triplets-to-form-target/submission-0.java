class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x=0;
        List<Integer> useFullarr = new ArrayList<>();
        for(int[] j: triplets){
            if(j[0]>target[0] || j[1]>target[1] || j[2]>target[2]){
                x++;
                continue;
            }
            useFullarr.add(x);
            x++;
        }

        int first = 0;
        int second =0;
        int third = 0;

        for(Integer i: useFullarr){
            int[] temp = triplets[i];
            if(temp[0]==target[0])first =1;
            if(temp[1]==target[1])second =1;
            if(temp[2]==target[2])third =1;
        }
        
        if(first!=0 && second!=0 && third!=0)return true;

        return false;
        
    }
}
