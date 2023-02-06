package next

import (
	"fmt"
	"testing"
)

func partition(s string) [][]string {
	dp := make([][]bool, len(s))
	for i := 0; i < len(s); i++ {
		dp[i] = make([]bool, len(s))
	}
	for right := 0; right < len(s); right++ {
		for left := 0; left <= right; left++ {
			if s[left] == s[right] && ((right-left < 2) || dp[left+1][right-1]) {
				dp[left][right] = true
			}
		}
	}
	var result [][]string
	var subResult []string
	dfsPartition(s, dp, 0, subResult, &result)
	return result
}
func dfsPartition(s string, dp [][]bool, start int, subResult []string, result *[][]string) {
	if start == len(s) {
		tmp := make([]string, len(subResult))
		copy(tmp, subResult)
		*result = append(*result, tmp)
		return
	}
	for i := start; i < len(s); i++ {
		if dp[start][i] {
			subResult = append(subResult, s[start:i+1])
			dfsPartition(s, dp, i+1, subResult[:], result)
			subResult = subResult[:len(subResult)-1]
		}
	}
}
func TestPartition(t *testing.T) {
	fmt.Println(partition("aabb"))
	fmt.Println(partition("efe"))
}
