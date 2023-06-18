// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.
// Example 1:
// Input: nums = [2,2,1]
// Output: 1
// Example 2:
// Input: nums = [4,1,2,1,2]
// Output: 4
// Example 3:
// Input: nums = [1]
// Output: 1

import scala.collection.mutable.Map
object Solution {
    def singleNumber(nums: Array[Int]): Int = {
        var map = Map[Int,Int]()
        var r:Int = Int.MinValue
        for(num <- nums){
            if(map.contains(num))
                map(num) = map(num)+1
            else
                map += (num->1)                
        }

        for((k,v) <- map){
            if(v == 1)
                r = k
        }
        r
    }
}
