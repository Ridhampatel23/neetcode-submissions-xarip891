class MedianFinder {

    /// Brute Forcing : Using sort Array, would create O(n log n) everytime
    /// find median is called, inefficient asf.

    List<Integer> arr;

    public MedianFinder() {
        this.arr = new ArrayList<>();
    }
    
    public void addNum(int num) {
        arr.add(num);
    }
    
    public double findMedian() {
        Collections.sort(arr);
        if (arr.size() % 2 == 0){
            int first = arr.get((arr.size() / 2) - 1); 
            int second = arr.get((arr.size() / 2)); 
            return (double) (first + second) / 2.0;
        } else {
            return (double) arr.get(arr.size() / 2);
        }
    }
}