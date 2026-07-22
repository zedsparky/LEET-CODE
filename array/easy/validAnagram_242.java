public class validAnagram_242 {
    /*
     * Approach:
     * Brute Force
     * 
     * Idea:
     * For every character in the first string, search for a matching
     * unused character in the second string. Once a match is found,
     * mark it as used so it cannot be matched again.
     * 
     * Why it works:
     * Every character from the first string must match exactly one
     * character in the second string. If any character cannot be
     * matched, the strings are not anagrams.
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(n)
     */
    public static boolean anagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] arr = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            boolean found = false;
            for (int j = 0; j < arr.length; j++) {
                if (s.charAt(i) == arr[j]) {
                    arr[j] = '*';
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static boolean optimalAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int freq[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            freq[t.charAt(j) - 'a']--;
        }
       
            for (int count : freq) {
                if (count != 0) {
                    return false;
                }
            }
        
        return true;
    }
}
