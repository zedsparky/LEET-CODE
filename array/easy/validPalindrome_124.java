
/**
 * validPalindrome_124
 */
public class validPalindrome_124 {

    public static boolean palindrome(String s){
        String str =s.toLowerCase();
        StringBuilder clean= new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                clean.append(ch);
            }
        }
            StringBuilder reverse= new StringBuilder(clean);
            reverse=reverse.reverse();
            if (clean.toString().equals( reverse.toString())) {
               return true;
            }
            return false;
        }
        public static boolean optimal(String s){
            int left=0;
            int right=s.length()-1;
            while (left<right) {
               while (left<right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
               }
               while (right<left && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(palindrome(s));
    }
}