import java.util.HashSet;
/*
Approach:
Brute Force

Idea:
Compare every element with all the elements that come after it.
If any two elements are equal, a duplicate exists.

Why it works:
The algorithm checks every possible pair of elements exactly once.
If a duplicate is present, one of these comparisons will find it.
If no equal pair is found after all comparisons, the array contains only unique elements.

Time Complexity: O(n²)
Space Complexity: O(1)
*/
public class containsDuplicate_217 {
    static boolean duplicate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]==nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    /*
Approach:
Optimal (HashSet)

Idea:
Traverse the array once. If the current element is already
present in the HashSet, a duplicate exists. Otherwise,
add the element to the HashSet.

Why it works:
HashSet provides average O(1) lookup and insertion,
allowing duplicate detection in a single traversal.

Time Complexity: O(n)
Space Complexity: O(n)
*/
    static boolean optimalDuplicate(int nums[]){
        HashSet<Integer> set= new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
           
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3,4};
        System.out.println("Optimale approach = "+optimalDuplicate(nums));
        System.out.println("brute approach = "+duplicate(nums));

    }
}
