/*
30. Substring with Concatenation of All Words
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
还有另外一种O(N)算法：
len(words[0])*len(s)/len(words[0])
*/

package main
import (
    "fmt"
)

func findSubstring(s string, words []string) []int {
    var retpos []int
    wmap := make(map[string]int)
    for i := 0; i < len(words); i++ {
        wmap[words[i]] += 1
    }

    //retpos = append(retpos, 1)
    if len(s) == 0 || len(words) == 0 || len(words[0]) == 0 {
        return retpos
    }
    wlen := len(words[0])
    tmap := make(map[string]int)
    count := 0
    for i := 0; i < len(s); i++ {
        for j := 0; j < len(words); j++ {
            start := i+j*wlen
            if start+wlen > len(s) {
                break
            }
            substr := s[start:start+wlen]
            if wmap[substr] == 0 {
                break
            }
            tmap[substr] += 1
            count++
            fmt.Println("find words:", substr)
        }
        iseq := true
        for k, v := range(wmap) {
            if tmap[k] != v {
                iseq = false
                break
            }
        }
        if count == len(words) && iseq == true {
            fmt.Println("find pos:", i)
            retpos = append(retpos, i)
        }
        count = 0
        for k, _ := range(tmap) {
            delete(tmap, k)
        }
    }
    return retpos
}

func main() {
    //words := []string{"bar","foo","the"}
    //s := "barfoofoobarthefoobarman"
    words := []string{"word","good","best","good"}
    s := "wordgoodgoodgoodbestword"
    fmt.Println("pos:", findSubstring(s, words))
}
