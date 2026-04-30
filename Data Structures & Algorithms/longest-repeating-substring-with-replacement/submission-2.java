class Solution {
    //Sliding window optimal (O(26n) -> O(n)) with a frequency map
    public int characterReplacement(String s, int k) {
        if (s.length() <= k) return s.length();
        int maxLen = -1;
        Map<Character, Integer> freq = new HashMap<>();
        int maxf = 0;
        int l = 0;
        for (int r = l; r < s.length(); r++){
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);

            maxf = Math.max(maxf, freq.get(s.charAt(r)));

            while ((r-l+1) - maxf > k){
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
        }

      
        return maxLen;
        
    }
}
