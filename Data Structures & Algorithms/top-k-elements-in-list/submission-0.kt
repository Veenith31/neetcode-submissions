class Solution {
fun topKFrequent(nums: IntArray, k: Int): IntArray {

     val frequenMap = HashMap<Int, Int>()
        for (num in nums) {
            frequenMap[num] = frequenMap.getOrDefault(num, 0) + 1
        }

     val minHeap = PriorityQueue<Int>(compareBy { frequenMap[it] })

     for (num in frequenMap.keys) {
            minHeap.offer(num)
            if (minHeap.size > k) {
                minHeap.poll() 
            }
        }

        return IntArray(k) { minHeap.poll() }
    }
}

