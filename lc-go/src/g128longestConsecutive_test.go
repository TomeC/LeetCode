package src

import (
	"testing"
)

func longestConsecutive(nums []int) int {
	type void struct{}
	if len(nums) == 0 {
		return 0
	}
	iset := make(map[int]void)
	for _, v := range nums {
		iset[v] = void{}
	}
	longest := 0
	for _, v := range nums {
		ilong := 1
		left := v - 1
		for {
			if _, ok := iset[left]; ok {
				ilong++
				delete(iset, left)
				left--
			} else {
				break
			}
		}
		right := v + 1
		for {
			if _, ok := iset[right]; ok {
				ilong++
				delete(iset, right)
				right++
			} else {
				break
			}
		}
		if ilong > longest {
			longest = ilong
		}
	}
	return longest
}
func TestLongestConsecutive(t *testing.T) {
	if longestConsecutive(nil) != 0 {
		t.FailNow()
	}
	if longestConsecutive([]int{100, 4, 200, 1, 3, 2}) != 4 {
		t.FailNow()
	}
	if longestConsecutive([]int{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}) != 9 {
		t.FailNow()
	}
	println("test over")
}
