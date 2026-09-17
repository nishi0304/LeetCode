class Solution {
    public int findDuplicate(int[] nums) {
        int low = nums[0];
        int high = nums[0];
        do {
            low = nums[low];
            high = nums[nums[high]];
        } while (low != high);
        low = nums[0];
        while (low != high) {
            low = nums[low];
            high = nums[high];
        }
        return low;
    }
}