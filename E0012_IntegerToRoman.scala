// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given an integer, convert it to a roman numeral.

object Solution {
    def romanToInt(s: String): Int = {
        var r:Int = 0;
        var i:Int = 1;
        var prev = 'Z'
        while(i <= s.length){
            val c = s(s.length - i)
            (c, prev) match {
                case ('I',v) if v == 'V' || v == 'X' => r = r - 1
                case ('X',v) if v == 'L' || v == 'C' => r = r - 10
                case ('C',v) if v == 'D' || v == 'M' => r = r - 100
                case ('I',_) => r = r + 1
                case ('V',_) => r = r + 5
                case ('X',_) => r = r + 10
                case ('L',_) => r = r + 50
                case ('C',_) => r = r + 100
                case ('D',_) => r = r + 500
                case ('M',_) => r = r + 1000
            } 
            prev = c
            i = i + 1
        }
    r
    }
}
