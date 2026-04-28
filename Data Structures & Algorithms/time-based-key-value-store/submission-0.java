public class TimeMap {
    private Map<String, Map<Integer, String>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // Just map timestamp directly to value
        keyStore.computeIfAbsent(key, k -> new HashMap<>())
                .put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!keyStore.containsKey(key)) return "";

        int latestTime = -1;
        // Brute force: check every timestamp for this key
        for (int time : keyStore.get(key).keySet()) {
            if (time <= timestamp) {
                latestTime = Math.max(latestTime, time);
            }
        }

        return (latestTime == -1) ? "" : keyStore.get(key).get(latestTime);
    }
}
