class Solution {
    public boolean checkInclusion(String s1, String s2) {
         if(s1.length() > s2.length())
            return false;

            int[] count1 = new int[26];
            int[] count2 = new int[26];

            for (int i = 0; i < s1.length(); i++){
                count1[s1.charAt(i) - 'a']++;
                count2[s2.charAt(i) - 'a']++;
            }

            int matches = 0;
            for (int i = 0; i < 26; i++) {
                if (count1[i] == count2[i]) {
                matches++;
                }
            }


            // Sliding window: we keep the length of the window = s1.length()
            // Everytime we check if matches are same 26
            // If not same, update the right pointer by one and add their freq to char arr
            // and update matches
            // At the same time remove the left var , update matches and update the left pointer by 1
            // This ensure everytime the window being same length, and we can run checks before each 
            // update to get the correct result

            int l = 0;
            for (int r = s1.length(); r < s2.length(); r++){
                if (matches == 26) return true;

                int index = s2.charAt(r) - 'a';
                count2[index]++;
                if(count1[index] == count2[index]){
                    matches++;
                } else if(count1[index] + 1 == count2[index]) {
                    matches--;
                }

                index = s2.charAt(l) - 'a';
                count2[index]--;
                if (count1[index] == count2[index]){
                    matches++;
                } else if (count1[index] - 1 == count2[index]){
                    matches--;
                }
                    l++;
            }
            


        
        return matches == 26;
    }
}
