/*35. Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
package main
import (
    "fmt"
)

func searchInsert(nums []int, target int) int {
    fmt.Println(nums, target)
    if len(nums) == 0{
        return -1
    }
    left := 0
    right := len(nums)-1
    var mid int
    for left <= right {
        mid = (right-left)/2+left
        fmt.Println(left, mid, right)
        if nums[mid] == target {
            return mid
        } else if nums[mid] > target {
            right = mid-1
        } else {
            left = mid+1
        }
    }
    return left
}

func main() {
    nums := []int{1,3}
    fmt.Println(searchInsert(nums, 2))
}
