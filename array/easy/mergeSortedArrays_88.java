import java.util.Arrays;

public class mergeSortedArrays_88 {
    /*
     * ---------------------------------------------------------
     * BRUTE FORCE APPROACH
     * 
     * Idea:
     * 1. nums1 already has enough extra space to store nums2.
     * 2. Copy every element of nums2 into the empty positions of nums1.
     * 3. After copying, nums1 contains all elements but is not sorted.
     * 4. Sort the complete nums1 array.
     * 5. nums1 becomes the final merged sorted array.
     * 
     * Time Complexity : O((m + n) log(m + n))
     * Space Complexity: O(log(m + n))
     * ---------------------------------------------------------
     */
    public static void BruteMerge(int nums1[], int m, int nums2[], int n) {
        /*
         * nums1 : First sorted array with extra empty space.
         * Example:
         * [1,2,3,0,0,0]
         * 
         * m : Number of VALID elements already present in nums1.
         * (Zeros after index m-1 are just placeholders.)
         * 
         * nums2 : Second sorted array.
         * Example:
         * [2,5,6]
         * 
         * n : Number of elements present in nums2.
         */

        /*
         * -----------------------------------------------------
         * STEP 1 : Copy nums2 into the empty positions of nums1.
         * 
         * Before Copy:
         * 
         * nums1 = [1,2,3,0,0,0]
         * ↑
         * First empty index = m
         * 
         * nums2 = [2,5,6]
         * 
         * We copy:
         * 
         * nums2[0] → nums1[3]
         * nums2[1] → nums1[4]
         * nums2[2] → nums1[5]
         * 
         * After Copy:
         * 
         * nums1 = [1,2,3,2,5,6]
         * -----------------------------------------------------
         */
        for (int i = 0; i < n; i++) {
            /*
             * i -> Current index of nums2.
             * 
             * m+i -> Current empty position inside nums1.
             * 
             * Copy one element from nums2
             * into the next available position of nums1.
             */
            nums1[m + i] = nums2[i];

        }
        /*
         * -----------------------------------------------------
         * STEP 2 : Sort the complete nums1 array.
         * 
         * Before Sorting:
         * [1,2,3,2,5,6]
         * 
         * After Sorting:
         * [1,2,2,3,5,6]
         * 
         * Arrays.sort() sorts the array in ascending order.
         * -----------------------------------------------------
         */
        Arrays.sort(nums1);
        System.out.print("Brute Force Result:");

        for (int num : nums1) {
            System.out.print(num + " ");
        }

        System.out.println();

        /*
         * nums1 now contains the final merged sorted array.
         * 
         * Final Output:
         * [1,2,2,3,5,6]
         */
    }

    public static void extraArrayMerge(int arr1[], int arr2[]) {
        /*
         * ---------------------------------------------------------
         * BETTER APPROACH (Using Extra Array)
         * 
         * Idea:
         * 1. Create a new array of size (m + n).
         * 2. Use three pointers:
         * i -> First array
         * j -> Second array
         * k -> Merged array
         * 3. Compare the current elements of both arrays.
         * 4. Insert the smaller element into the merged array.
         * 5. Move the corresponding pointer.
         * 6. If one array finishes first, copy all remaining
         * elements from the other array.
         * 7. The merged array contains all elements in sorted order.
         * 
         * Time Complexity : O(m + n)
         * Space Complexity: O(m + n)
         * ---------------------------------------------------------
         */
        int m = arr1.length;
        int n = arr2.length;
        int[] merged = new int[m + n];
        int i = 0; // i -> Traverses first array.
        int j = 0; // j -> Traverses second array.
        int k = 0; // k -> Traverses merged array.

        /*
         * Compare elements from both arrays.
         * Copy the smaller element into merged[].
         * Continue until one of the arrays is exhausted.
         */
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {

                merged[k] = arr1[i];

                i++;
                k++;
            } else {
                merged[k] = arr2[j];
                j++;
                k++;
            }
        }
        while (j < n) {
            merged[k] = arr2[j];
            j++;
            k++;
        }
        while (i < m) {
            merged[k] = arr1[i];
            i++;
            k++;
        }
        System.out.print("Merged via Extra array:");
        for (int num : merged) {
            System.out.print(num + " ");
        }

    }
/*
---------------------------------------------------------
OPTIMAL APPROACH (Three Pointers - In Place Merge)

Idea:
1. Start comparing elements from the END of both arrays.
2. Place the larger element at the last available position
   of nums1.
3. Move the corresponding pointer backward.
4. Continue until one array is exhausted.
5. If nums2 still has remaining elements, copy them into nums1.
6. No need to copy remaining elements of nums1 because they
   are already in their correct positions.

Time Complexity : O(m + n)
Space Complexity: O(1)
---------------------------------------------------------
*/
    public static void optimalMerge(int[] num1, int m, int[] num2, int n) {
        int i = m - 1; //i -> Points to the last VALID element of num1.
        int j = n - 1; //j -> Points to the last element of num2.
        int k = m + n - 1; //k -> Points to the last position of num1
        
    /*
     * Compare elements from the END of both arrays.
     * Place the larger element at index k.
     * Move the corresponding pointer backward.
     */
        while (i >= 0 && j >= 0) {
            if (num1[i] > num2[j]) {
                  // num1 has the larger element.
            // Place it at the end and move i backward.
                num1[k] = num1[i];
                i--;
                k--;
            } else {
                   // num2 has the larger (or equal) element.
            // Place it at the end and move j backward.
                num1[k] = num2[j];
                j--;
                k--;
            }

        }
         /*
     * If num2 still contains elements,
     * copy all of them into num1.
     *
     * We DO NOT need another loop for num1 because
     * its remaining elements are already in the
     * correct positions.
     */
        while (j >= 0) {
            num1[k] = num2[j];
            j--;
            k--;
        }
        System.out.println();
        System.out.print("optimally merged = ");
        for (int arr : num1) {
            System.out.print(arr + " ");
        }

    }

    public static void main(String[] args) {
        int nums1[] = { 10, 20, 30, 0, 0, 0 };
        int nums2[] = { 40, 50, 60 };
        BruteMerge(nums1, 3, nums2, 3);

        int arr1[] = { 10, 20, 30 };
        int arr2[] = { 40, 50, 60 };
        extraArrayMerge(arr1, arr2);

        int num1[] = { 10, 20, 30, 0, 0, 0 };
        int num2[] = { 40, 50, 60 };
        optimalMerge(num1, 3, num2, 3);
    }
}
