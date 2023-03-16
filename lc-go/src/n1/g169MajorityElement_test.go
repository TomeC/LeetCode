package next

import (
	"math/rand"
	"testing"
)

func majorityElement(nums []int) int {
	usedMap := make(map[int]bool)
	for {
		index := rand.Intn(len(nums))
		if _, ok := usedMap[index]; ok {
			continue
		}
		usedMap[index] = true
		count := 0
		for i := 0; i < len(nums); i++ {
			if nums[i] == nums[index] {
				count++
			}
		}
		if count > len(nums)/2 {
			return nums[index]
		}
	}
}
func TestMajortyElement(t *testing.T) {
	if majorityElement([]int{3, 2, 3}) != 3 {
		t.FailNow()
	}
}
