class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int largest = 1;
        int count = 1;

        for (int j = 0; j < sorted.length - 1; j++) {
            if (sorted[j + 1] == sorted[j]) {
                continue; // duplicate, skip without touching count
            }
            if (sorted[j + 1] - sorted[j] == 1) {
                count++;
            } else {
                largest = Math.max(largest, count);
                count = 1; // reset for next streak
            }
        }
        largest = Math.max(largest, count); // catch streak ending at array's end

        return largest;
    }
}