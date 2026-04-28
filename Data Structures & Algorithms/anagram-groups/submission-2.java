class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); //pair: String, anagram
        
        for (String s : strs){
            int[] charMap = new int[26];

            for(int i = 0; i < s.length(); i++){
                charMap[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(charMap);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(map.values());
    
    }
}
