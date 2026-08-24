class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long required = (long) m * k;
        if (bloomDay.length < required) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int consecutive = 0;
        for (int day : bloomDay) {
            if (day <= days) {
                consecutive++;
                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0;
                    if (bouquets == m) {
                        return true;
                    }
                }
            } else {
                consecutive = 0;
            }
        }
        return false;
    }
}