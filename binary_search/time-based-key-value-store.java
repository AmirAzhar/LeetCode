// https://leetcode.com/problems/time-based-key-value-store/description/

// Java
class TimeMap {

    public Map<String, ArrayList<Time>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // key doesn't exist yet, add a new list
        if (!map.containsKey(key)) {
            ArrayList<Time> newList = new ArrayList<>();
            newList.add(new Time(value, timestamp));
            map.put(key, newList);
        } else {
            ArrayList<Time> currList = map.get(key);

            // Binary search to find insertion point
            int l = 0, r = currList.size();

            while (l < r) {
                int mid = (r + l) / 2;
                if (timestamp > currList.get(mid).timestamp) l = mid + 1;
                else r = mid;
            }

            // If timestamp equals existing one, overwrite
            if (l < currList.size() && currList.get(l).timestamp == timestamp) {
                currList.set(l, new Time(value, timestamp));
            } else {
                currList.add(l, new Time(value, timestamp));
            }
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        ArrayList<Time> currList = map.get(key);

        int l = 0, r = currList.size() - 1;
        String res = "";

        while (l <= r) {
            int mid = (r + l) / 2;
            if (currList.get(mid).timestamp <= timestamp) {
                res = currList.get(mid).value;
                l = mid + 1;
            }
            else r = mid - 1; 
        }

        return res;
    }
}

class Time {
    public String value;
    public int timestamp;

    public Time (String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}