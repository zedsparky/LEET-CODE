public class moveZeros_283 {
    /*
---------------------------------------------------------
BRUTE FORCE APPROACH

Idea:
1. Create a temporary array.
2. Copy all non-zero elements into it.
3. Fill the remaining positions with zero.
4. Copy the temporary array back to the original array.

Time Complexity : O(n)
Space Complexity: O(n)
---------------------------------------------------------
*/

    static void bruteForce(int[] nums) {

        int[] arr = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                arr[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    /*
---------------------------------------------------------
OPTIMAL APPROACH (Two Pointers)

Idea:
1. Maintain a pointer (index) that stores the position
   where the next non-zero element should be placed.
2. Traverse the array using another pointer (i).
3. Whenever a non-zero element is found, swap it with
   nums[index].
4. Increment index after placing the non-zero element.
5. By the end of traversal, all non-zero elements are
   at the beginning and all zeros automatically move
   to the end.

Time Complexity : O(n)
Space Complexity: O(1)
---------------------------------------------------------
*/
    static void optimal(int [] nums){
       
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                int temp=nums[index];
                nums[index]=nums[i];
                nums[i]=temp;
                index++;
            }
        }
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int nums[] = { 10, 5, 0, 6, 4, 0, 8, 0, 0 };
        System.out.println("brute force = ");
        bruteForce(nums);
        System.out.println();
        System.out.println("optimal solution = ");
        optimal(nums);

    }
}
