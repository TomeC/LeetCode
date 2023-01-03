package src

import (
	"testing"
)

func wordBreak(s string, wordDict []string) bool {
	dp := make([]bool, len(s)+1)
	dp[0] = true
	wordSet := make(map[string]bool)
	for _, s := range wordDict {
		wordSet[s] = true
	}
	for i := 1; i <= len(s); i++ {
		for j := i; j > 0; j-- {
			if dp[j-1] {
				if _, ok := wordSet[s[j-1:i]]; ok {
					dp[i] = true
					break
				}
			}
		}
	}
	return dp[len(s)]
}
func TestWordBeak(t *testing.T) {
	if wordBreak("ltcd", []string{"lt", "cd"}) != true {
		t.FailNow()
	}
}
