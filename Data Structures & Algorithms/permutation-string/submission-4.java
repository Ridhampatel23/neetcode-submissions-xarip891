class Solution {
    public boolean checkInclusion(String s1, String s2) {
         if(s1.length() > s2.length())
            return false;

        Map<Character, Integer> countsMap1 = new HashMap<>();
        for (char c : s1.toCharArray()){
            countsMap1.put(c, countsMap1.getOrDefault(c, 0) + 1);
        }

            int k = countsMap1.size();
        for (int i = 0; i < s2.length(); i++){
            Map<Character, Integer> countsMap2 = new HashMap<>();
            int curr = 0;
            for (int j = i; j < s2.length(); j++){
                char c = s2.charAt(j);
                countsMap2.put(c, countsMap2.getOrDefault(c, 0) + 1);

                if (countsMap1.getOrDefault(c, 0) < countsMap2.get(c)) break;

                if(countsMap1.get(c) == countsMap2.get(c)) curr++;

                if(curr == k) return true;

                
            }
        }



        
        return false;
    }
}
