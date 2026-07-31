import java.util.Arrays;

public class reverseString_344 {
    public static void reverse(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] arr = { 'h', 'e', 'l', 'l', 'o' };

        reverse(arr);

        System.out.println(Arrays.toString(arr));
    }
}
