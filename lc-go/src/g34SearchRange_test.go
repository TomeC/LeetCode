package src

import (
	"fmt"
	"testing"
)

/* 34. Search for a Range
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
func searchRange(nums []int, target int) []int {
	rets := []int{-1, -1}
	if len(nums) == 0 {
		return rets
	}
	left := 0
	right := len(nums) - 1
	for left <= right {
		mid := (right-left)/2 + left
		fmt.Println(left, mid, right)
		if target == nums[mid] {
			rets[0] = mid
			rets[1] = mid
			for i := mid - 1; i >= 0; i-- {
				if nums[i] == target {
					rets[0] = i
				} else {
					break
				}
			}
			for i := mid + 1; i < len(nums); i++ {
				if nums[i] == target {
					rets[1] = i
				} else {
					break
				}
			}
			return rets
		} else if target > nums[mid] {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return rets
}

//go test -v g34SearchRange_test.go
func TestSearchRange(t *testing.T) {
	arr := []int{8}
	fmt.Println(searchRange(arr, 8))
}
