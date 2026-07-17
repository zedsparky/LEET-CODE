
public class removeDuplicates_26 {
    /*
---------------------------------------------------------
Approach 1 : Brute Force (Using Extra Array)
---------------------------------------------------------

Idea:
1. Create a temporary array to store unique elements.
2. Traverse the original array.
3. For every element, search whether it already exists
   in the temporary array.
4. If it doesn't exist, copy it into the temporary array.
5. Copy all unique elements back into the original array.
6. Return the number of unique elements.

Why it works?
- The temporary array always contains only unique values.
- Duplicate elements are ignored.

Time Complexity:
O(n²)
For every element, we may search the temporary array.

Space Complexity:
O(n)
Extra array is used.
*/
    public int removeDuplicates(int[] nums) {

        int[] temp = new int[nums.length];
        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            boolean found = false;

            for (int j = 0; j < k; j++) {
                if (temp[j] == nums[i]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                temp[k] = nums[i];
                k++;
            }
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }

        return k;
    }
    /*
---------------------------------------------------------
Approach 2 : Optimal (Two Pointer)
---------------------------------------------------------

Idea:
1. Since the array is already sorted,
   duplicate elements always appear next to each other.
2. Assume the first element is always unique.
3. Use two pointers:
      unique -> points to the last unique element.
      i      -> scans the remaining array.
4. Whenever a new unique element is found,
   move the unique pointer one step forward
   and copy the new element there.
5. Return the total number of unique elements.

Why it works?
- Sorted arrays keep duplicates together.
- We only compare the current element with
  the last unique element instead of searching
  the entire array.

Time Complexity:
O(n)
Each element is visited only once.

Space Complexity:
O(1)
No extra space is used.
*/

    static int remove(int []nums){
       
        int count=0;
        for (int i = 1; i < nums.length; i++) {
            
            if (nums[count]!=nums[i]) {
                count++;
                nums[count]=nums[i];
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        int nums[]={10,10,20,20,30,40,50};
        remove(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}