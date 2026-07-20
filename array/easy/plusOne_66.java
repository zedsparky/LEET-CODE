import java.util.Arrays;

public class plusOne_66 {
    public static int[] plusOne(int[] digits) {
/*
---------------------------------------------------------
Approach : Optimal (Carry Propagation)
---------------------------------------------------------

Idea:
1. Start from the last digit because addition begins
   from the least significant digit.
2. If the current digit is less than 9,
   increment it and return immediately.
3. If the current digit is 9,
   make it 0 and continue to propagate the carry.
4. If every digit becomes 0,
   create a new array with one extra digit
   and place 1 at the beginning.

Why it works?
- Carry only propagates while digits are 9.
- As soon as a digit becomes less than 9,
  the carry is resolved and no further processing
  is required.
- If all digits are 9, the number gains one digit.

Time Complexity:
O(n)

Space Complexity:
O(1)
(Only O(n) when a new array is created in the all-9s case,
which is required by the problem.)
*/
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;

        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
    public static void main(String[] args) {
        int []digits={1,2,3};
        int[] answer=plusOne(digits);
        System.out.println(Arrays.toString(answer));
    }
}
