//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//An input string is valid if:
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//Example 1:
//Input: s = "()"
//Output: true
//Example 2:
//Input: s = "()[]{}"
//Output: true
//Example 3:
//Input: s = "(]"
//Output: false

import collection.mutable.Stack
object Solution {
    def isValid(s: String): Boolean = {
        if(s.length < 2) return false
        var stack = Stack[Char]()
        for(ch <- s){
            ch match {
                case '{' | '(' | '[' => 
                    stack.push(ch)
                case '}' if(stack.length > 0) => 
                    if(stack.pop != '{') return false
                case ')' if(stack.length > 0) => 
                    if(stack.pop != '(') return false
                case ']' if(stack.length > 0)  => 
                    if(stack.pop != '[') return false
                case _ => return false                   
            }
        }
        if(stack.length > 0)
            false
        else
            true

    }
}
