class Solution {
    //More readable solution than the one where we keep track of matches and could be more error prone
    //Only tradeoff, We check every single index in array everytime we compare so the operation is O(26)
    //but compilers make it O(1) anyways, might as well keep this solution to stay bug free and have a
    //set approach to sliding window!!
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        
        // Count frequencies in s1
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }
        
        // Sliding window of size s1.length()
        for (int i = 0; i < s2.length(); i++) {
            // Add right character
            count2[s2.charAt(i) - 'a']++;
            
            // Remove left character (when window is full)
            if (i >= s1.length()) {
                count2[s2.charAt(i - s1.length()) - 'a']--;
            }
            
            // Check if frequencies match
            if (i >= s1.length() - 1 && Arrays.equals(count1, count2)) {
                return true;
            }
        }
        
        return false;
    }
}