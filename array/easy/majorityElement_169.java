
public class majorityElement_169 {
    // brute force approach

    public static int majorityElementBruteForce(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }

            }
            if (count > n / 2) {
                return nums[i];

            }

        }
        return -1;
    }

    // boyr moore optimal solution

    public static int MajorityElementMooreAlgo(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }

        }
        return candidate;

    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println("Majority element = " + majorityElementBruteForce(nums));
        System.out.println("majority element via moore : = " + MajorityElementMooreAlgo(nums));

    }
}