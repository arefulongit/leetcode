// 217. Contains Duplicate
// Easy
// 9.3K
// 1.2K
// Companies
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Example 1:

// Input: nums = [1,2,3,1]
// Output: true
// Example 2:

// Input: nums = [1,2,3,4]
// Output: false
// Example 3:

// Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true

import scala.collection.mutable.Map
object Solution {
    def containsDuplicate(nums: Array[Int]): Boolean = {
        var i:Int = 0
        var map = Map[Int,Int]()
        for(num <- nums){
            if(map.contains(num)){
                return true
            } else {
                map += (num->1)
            }
        }
        false
    }
}
