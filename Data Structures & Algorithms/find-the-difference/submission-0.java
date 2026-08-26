class Solution {
    public char findTheDifference(String s, String t) {
        int[] sFreq = new int[26];
        

        for (char c : s.toCharArray()){
            sFreq[c - 'a']++;
        }

        for (char c : t.toCharArray()){
            sFreq[c - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if (sFreq[i] != 0){
                return (char)(i + 'a');
            }
        }
        return 'a';
    }
}