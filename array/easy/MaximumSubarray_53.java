public class MaximumSubarray_53 {
/*
 * Brute Force Approach
 *
 * Algorithm:
 * 1. Consider every possible subarray.
 * 2. For each starting index, extend the subarray one element at a time.
 * 3. Keep a running sum while extending.
 * 4. Update the maximum sum whenever a larger sum is found.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */
    public static int SubArray(int nums[]) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
/*
 * Optimal Approach (Kadane's Algorithm)
 *
 * Algorithm:
 * 1. Traverse the array only once.
 * 2. At each element, decide whether to:
 *    - Start a new subarray from the current element, or
 *    - Extend the previous subarray.
 * 3. Update the maximum sum found so far.
 * 4. Return the maximum subarray sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxsum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxsum = Math.max(maxsum, currentSum);
        }

        return maxsum;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 5, 7, 15, 9, 3, 0, -8, -5 };
        System.out.println(SubArray(nums));
        System.out.println(maxSubArray(nums));
    }
}