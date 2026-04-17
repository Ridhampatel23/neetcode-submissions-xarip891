class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); //pair: String, anagram
        
        for (String curr : strs){
            int[] count = new int[26];
            for (char c : curr.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(curr);
        }
        return new ArrayList<>(map.values());
    }
}
