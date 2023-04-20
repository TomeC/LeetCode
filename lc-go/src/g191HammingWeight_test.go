package src

import "testing"

func hammingWeight(num uint32) int {
	var count int = 0
	for i := 0; i < 32; i++ {
		if (num>>i)&1 == 1 {
			count++
		}
	}
	return count
}
func TestHammingWeight(t *testing.T) {
	if hammingWeight(11) != 3 {
		t.FailNow()
	}
	if hammingWeight(16) != 1 {
		t.FailNow()
	}
}
