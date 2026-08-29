class Solution {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1;
        int high = position[n - 1] - position[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (requiredForce(position, mid, m)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    public boolean requiredForce(int[] position, int distance, int m) {
        int count = 1;
        int lastPosition = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= distance) {
                count++;
                lastPosition = position[i];
            }
            if (count >= m) {
                return true;
            }
        }
        return false;
    }
}