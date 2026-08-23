class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int answer = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalHours = calculateTotalHours(piles, mid);
            if (totalHours <= h) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
    public long calculateTotalHours(int[] piles, int k) {
        long totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + (long) k - 1) / k;
        }
        return totalHours;
    }
}