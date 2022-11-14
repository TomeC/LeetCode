/* 32. Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

package main

import (
    "fmt"
)
func longestValidParentheses(s string) int {
    fmt.Println("string:", s)
    plen := make([]int, len(s))
    maxlen := 0
    leftp := 0
    for i := 0; i < len(s); i++ {
        if s[i] == '(' {
            leftp++
        }
        if s[i] == ')' && leftp > 0 {
            plen[i] = plen[i-1]+2
            if i > plen[i] {
                plen[i] += plen[i-plen[i]]
            }
            if maxlen < plen[i] {
                maxlen = plen[i]
            }
            leftp--
        }
    }
    fmt.Println(plen)
    return maxlen
}
func main() {
    s := "()()((())())"
    fmt.Println(longestValidParentheses(s))
}
