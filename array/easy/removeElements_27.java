

public class removeElements_27 {
      /*
    ---------------------------------------------------------
    Approach 1 : Brute Force (Using Extra Array)
    ---------------------------------------------------------

    Idea:
    1. Create a temporary array.
    2. Traverse the original array.
    3. Copy only those elements which are not equal to val.
    4. Copy the valid elements back into the original array.
    5. Return the number of remaining elements.

    Time Complexity : O(n)
    Space Complexity: O(n)
    */

    public static int removeElement(int[] nums, int val) {

        int[] removedArray = new int[nums.length];
        int count = 0;

        // Copy all elements except val into the temporary array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                removedArray[count] = nums[i];
                count++;
            }
        }

        // Copy the valid elements back to nums
        for (int i = 0; i < count; i++) {
            nums[i] = removedArray[i];
        }

        return count;
    }

    /*
---------------------------------------------------------
Approach 2 : Optimal (Two Pointer)
---------------------------------------------------------

Idea:
1. Traverse the array using a read pointer.
2. Copy only the required elements into the front
   of the same array using a write pointer.
3. Return the number of remaining elements.

Why it works?
- Every element that should be kept is moved
  to the front of the array.
- Elements equal to val are skipped.
- The order of the remaining elements is preserved.

Time Complexity:
O(n)
Each element is visited exactly once.

Space Complexity:
O(1)
No extra array is used.
*/
    public static int  remove(int []nums, int val){
        int count =0;
       for (int i = 0; i < nums.length; i++) {
         if (nums[i]!=val) {
            nums[count]=nums[i];
            count ++;
         }
       }
       return count;
    }
        public static void main(String[] args) {

        int[] nums = {2, 2, 3, 4, 5};
        int val = 2;

        int k = removeElement(nums, val);
            System.out.println("BRUTE FORCE");
        System.out.println("Number of remaining elements = " + k);

        System.out.print("Array after removing " + val + " : ");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
           
        } System.out.println();
        System.out.println();

        System.out.println("OPTIMAL APPROACH");
        int removed=remove(nums, val);
    System.out.println("Number of remaining elements = " + removed);

        System.out.print("Array after removing " + val + " : ");

        for (int i = 0; i < removed; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
