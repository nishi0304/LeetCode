class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1,answer=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[low]<=nums[mid]){
                answer=Math.min(answer,nums[low]);
                low=mid+1;
            }
            else{
                high=mid-1;
                answer=Math.min(answer,nums[mid]);
            }
        }
        return answer;
    }
}