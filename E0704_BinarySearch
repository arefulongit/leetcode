//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
//You must write an algorithm with O(log n) runtime complexity.
//Example 1:
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
//Example 2:
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
object Solution {
    def search(nums: Array[Int], target: Int): Int = {
        def rs(beginIndex:Int, endIndex:Int):Int={
            // Интервал между начальным и конечным индексом в массиве имеет 
            // чётное/не чётное количество элементов от этого будет зависить 
            // обработка интервала.
            // !Не последний индекс, а именно длинну, поэтому "+1"!
            val intervalLength = endIndex - beginIndex + 1
            // Определяем середину интервала, в зависимости от чётности/нечётности
            // длинны интервала по среднему индексу будет стоять элемент(нечётный)
            // слева и справа от которого будут подинтервалы одинаковой длинны (нечетный)
            // или это будет конечный индекс левого подинтервала (чётная длинна)
            val middleIndex = beginIndex + intervalLength / 2
            if(intervalLength % 2 == 1){
                // Интервал нечётной длинны. Значит индекс указывает на средний элемент
                // с двумя подинтервалами по сторонам
                if(beginIndex == endIndex && nums(beginIndex) != target)
                    return -1
                else if(nums(middleIndex)==target)
                    return middleIndex
                else if(nums(middleIndex)>target)
                    return rs(beginIndex, middleIndex-1)
                else if(nums(middleIndex)<target)
                    return rs(middleIndex+1, endIndex)
                return -1                    
            } else {
                // Индекс указывает на последний элемент левого подинтервала значит
                // режет массив ровно паполам с двумя подинтервалами
                // с beginIndex по middleIndex-1 и с middleIndex по endIndex
                if(nums(middleIndex-1)==target)
                    return middleIndex-1
                else if(nums(middleIndex-1)>target)
                    return rs(beginIndex, middleIndex-1)
                if(nums(middleIndex)==target)
                    return middleIndex
                else if(nums(middleIndex)<target)
                    return rs(middleIndex, endIndex)                
            }
            return -1
       }
        rs(0, nums.size-1)
    }
}
