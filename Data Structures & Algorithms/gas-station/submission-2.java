class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gastotal = 0;
        int costtotal =0;
        int currgas =0;
        int ans =0;

        for(int i=0;i<gas.length;i++){
            gastotal += gas[i];
            costtotal += cost[i];
        }

        if(costtotal>gastotal)return -1;

        for(int i=0;i<gas.length;i++){
            currgas += (gas[i]-cost[i]);

            if(currgas<0){
                ans = i+1;
                currgas =0;
            }
            
        }

        return ans;
    }
}
