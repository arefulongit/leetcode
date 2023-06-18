//You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//Merge all the linked-lists into one sorted linked-list and return it.
//Example 1:
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[ 1->4->5, 1->3->4, 2->6]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
//Example 2:
//Input: lists = []
//Output: []
//Example 3:
//Input: lists = [[]]
//Output: []
/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def mergeKLists(lists: Array[ListNode]): ListNode = {
        var firstNode:ListNode = null
        var currentNode:ListNode = null
        var prevNode:ListNode = null
        var flagOfContinue = true
        //while(true){
        do{
            // Получим номер списка в массиве переданных нам списков
            // голова которого имеет самый маленький x
            var min = Int.MaxValue
            var countOfList = 0
            var countOfEmptyList = 0
            var memoriziedNumOfList = 0
            for(list<-lists){
                if(list == null) {
                    countOfEmptyList = countOfEmptyList + 1
                } else if(list != null && list.x < min){
                    min = list.x
                    memoriziedNumOfList = countOfList
                }
                countOfList = countOfList + 1
            }
            if(countOfEmptyList == countOfList) {
                // Если все списки пустые, то нужно выходить больше сделать
                // уже ничего нельзя
                flagOfContinue = false
            } else {
                // Сейчас у нас в min = самая маленькое значение х
                // из голов списков переданных массиве,
                // а в memoriziedNumOfList = индекс списка в массиве с 
                // самой маленьким значением x
                // Из min формируем новоую свободную ноду 
                var newNode = new ListNode(min, null)
                // и подключаем её к возвращаемому списку
                if(firstNode == null){
                    firstNode = newNode
                    prevNode = firstNode
                } else {
                    prevNode.next = newNode
                }
                prevNode = newNode
                // а списку с самой маленькой головой откусываем голову
                lists(memoriziedNumOfList) = lists(memoriziedNumOfList).next
            }
        }while(flagOfContinue)
        firstNode
    }
}
