class Solution {
    //Sliding window approach using hashmaps and two counter variables
    // for what the target is and what we currently have
    public String minWindow(String s, String t) {

        // Forgot to put the edge case
        if (t.isEmpty()) return "";

        Map<Character, Integer> tFreq = new HashMap<>();
        for(char curr : t.toCharArray()){
             tFreq.put(curr, tFreq.getOrDefault(curr, 0) + 1);
        }

        int target = tFreq.size();
        int have = 0;

        Map<Character, Integer> window = new HashMap<>();
        int[] res = new int[]{-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < s.length(); r++){
            char curr = s.charAt(r);
            window.put(curr, window.getOrDefault(curr, 0) + 1);

            if (tFreq.containsKey(curr) && window.get(curr).equals(tFreq.get(curr))) {
                have++;
            }

            while(have == target){
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char toRemove = s.charAt(l);
                window.put(toRemove, window.get(toRemove) - 1);

                if (tFreq.containsKey(toRemove) && window.get(toRemove) < tFreq.get(toRemove)) {
                have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);  
        
    }
}
