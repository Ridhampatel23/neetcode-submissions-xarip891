class Twitter {

    private int time;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    
    public Twitter() {
        this.time = 0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[]{time, tweetId});
        if (tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        // 1. Get all the followees inclduing the user itself
        Set<Integer> ids = followMap.getOrDefault(userId, new HashSet<>());
        ids.add(userId);

        // 2. Push the latest tweet of each user onto the heap
        for (Integer id : ids){
            if (tweetMap.containsKey(id)){
                List<int[]> tweets = tweetMap.get(id);
                int lastIdx = tweets.size() - 1;
                int[] lastTweet = tweets.get(lastIdx);
                // Store: {time, tweetId, userId, index}
                pq.offer(new int[]{lastTweet[0], lastTweet[1], id, lastIdx});
            }
        }

        // 3. Pop the top (most recent) tweet from pq
        // and push the next lastIdx from the same user
        while (!pq.isEmpty() && res.size() < 10){
            int[] curr = pq.poll();
            res.add(curr[1]);

            int nextIdx = curr[3] - 1;
            if (nextIdx >= 0){
                int[] nextTweet = tweetMap.get(curr[2]).get(nextIdx);
                pq.offer(new int[]{nextTweet[0], nextTweet[1], curr[2], nextIdx});
            }

        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
