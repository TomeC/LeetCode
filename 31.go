/* 31 Next Permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

6,3,5,4,2,1
6 4 1 2 3 5
思路：从后向前遍历找到nums[i]>nums[i-1]，接着找到第一个大于nums[i-1]的nums[j],swap(nums[i-1], nums[j])，逆转i-len(nums)
*/

package main
import (
    "fmt"
    //"sort"
)

func nextPermutation(nums []int)  {
    nlen := len(nums)
    var i int
    for i = nlen-1; i > 0; i-- {
        if nums[i] > nums[i-1] {
            for j := nlen-1; j >= i; j-- {
                if nums[j] > nums[i-1] {
                    nums[j], nums[i-1] = nums[i-1], nums[j]
                    fmt.Println(i-1, " swap-> ", nums)
                    break
                }
            }
            break
        }
    }
    fmt.Println(i, (nlen+i-1)/2)
    for j := i; j <= (nlen+i-1)/2; j++ {
        fmt.Println(j, "<->", nlen+i-j-1)
        nums[j], nums[nlen+i-j-1] = nums[nlen+i-j-1], nums[j]
        fmt.Println(j, "j->", nums)
    }
    
}

func main() {
    //nums := []int{1,1,5}
    //nums := []int{1,3,2}
    //nums := []int{2,3,1}
    nums := []int{6,5,4,3,2,1,0}
    nextPermutation(nums)
    fmt.Println(nums)
}
