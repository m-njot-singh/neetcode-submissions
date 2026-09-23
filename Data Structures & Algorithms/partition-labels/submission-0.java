class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),Math.max(map.getOrDefault(s.charAt(i),i),i));
        }

        // System.out.println(map);
        int start = 0;
        int end =0;

        for(int i=0;i<s.length();i++){
            int temp = map.get(s.charAt(i));
            end =Math.max(temp,end);
            
            if(i==end){
                ans.add(i-start+1);
                start = i+1;
            }
        }

        return ans;
    }
}
