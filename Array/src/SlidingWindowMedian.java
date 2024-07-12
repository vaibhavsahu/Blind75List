//import java.util.Comparator;
//import java.util.PriorityQueue;
//import java.util.TreeMap;
//
//public class SlidingWindowMedian {
//
//    TreeMap<Integer, Integer> minHeap = new TreeMap<>();
//    TreeMap<Integer, Integer> maxHeap = new TreeMap<>(Comparator.reverseOrder());
//
//
//    public double[] medianSlidingWindow(int[] nums, int k) {
//        int n = nums.length - k + 1;
//        if (n <= 0) {
//            return new double[0];
//        }
//        double[] result = new double[n];
//
//        for (int i = 0; i < k; i++) {
//            add(nums[i]);
//        }
//
//        for (int i = k; i < nums.length; i++) {
//            if(maxHeap.containsKey(nums[i-k])){
//                maxHeap.remove(nums[i-k]);
//            } else{
//                minHeap.remove(nums[i-k]);
//            }
//            if (nums[i] > getMedian()) {
//                minHeap.put(nums[i], minHeap.getOrDefault(nums[i], 0)+1);
//            } else {
//                maxHeap.put(nums[i], maxHeap.getOrDefault(nums[i], 0)+1);
//            }
//            if(k % 2 != 0) {
//                result[i-k] = minHeap.firstKey();
//            } else{
//                result[i-k] = (double)(minHeap.firstKey() + maxHeap.firstKey())/2.0;
//            }
//        }
//        return result;
//    }
//
//    private void add(int num) {
//
//        rebalance();
//    }
//
//
//    private double getMedian() {
//        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
//            return 0;
//        }
//        if (minHeap.size() == maxHeap.size()) {
//            return (minHeap.firstKey() + (double) maxHeap.firstKey()) / 2.0;
//        }
//        return !maxHeap.isEmpty() ? maxHeap.firstKey() : minHeap.firstKey();
//    }
//
//    private void rebalance() {
//        if (minHeap.size() - maxHeap.size() > 1) {
//            double key  = minHeap.firstKey();
//            maxHeap.put(key, maxHeap.getOrDefault(key, 0)+1);
//            minHeap.remove(minHeap.firstKey());
//        } else if (maxHeap.size() - minHeap.size() > 1) {
//            double key  = maxHeap.firstKey();
//            minHeap.put(key, minHeap.getOrDefault(key, 0)+1);
//            maxHeap.remove(maxHeap.firstKey());
//        }
//    }
//}
