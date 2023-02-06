package next

import "testing"

func findPeakElement(nums []int) int {
	if len(nums) < 2 || nums[0] > nums[1] {
		return 0
	}
	if nums[len(nums)-1] > nums[len(nums)-2] {
		return len(nums) - 1
	}
	for i := 1; i < len(nums)-1; i++ {
		if nums[i] > nums[i-1] && nums[i] > nums[i+1] {
			return i
		}
	}
	return -1
}
func TestFindPeakElement(t *testing.T) {
	if findPeakElement([]int{1, 2}) != 1 {
		t.FailNow()
	}
	if findPeakElement([]int{1, 2, 3, 1}) != 2 {
		t.FailNow()
	}
	if findPeakElement([]int{1, 2, 1, 3, 5, 6, 4}) != 1 {
		t.FailNow()
	}
}
