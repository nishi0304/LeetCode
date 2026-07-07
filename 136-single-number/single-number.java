class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
             int num=nums[i];
            int counter=0;
            for(int j=0;j<n;j++){
                if(nums[j]==num){
                    counter++;
                }}
                if(counter==1){
                    return num;
                }
            
    }
    return -1;
}
}