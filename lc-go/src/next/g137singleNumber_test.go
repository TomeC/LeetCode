package next

import "testing"

func singleNumber(nums []int) int {
	var result int32 = 0
	for i := 0; i < 32; i++ {
		sum := 0
		for j := 0; j < len(nums); j++ {
			b := (nums[j] >> i) & 1

			if b != 0 {
				sum += 1
			}
		}
		if sum%3 > 0 {
			result |= (1 << i)
		}

	}
	println("result:", result)
	return int(result)

}
func singleNumber2(nums []int) int {
	ans := int32(0)
	for i := 0; i < 32; i++ {
		total := int32(0)
		for _, num := range nums {
			total += int32(num) >> i & 1
		}
		if total%3 > 0 {
			ans |= 1 << i
		}
	}
	return int(ans)
}

func TestSingleNumber(t *testing.T) {
	if singleNumber([]int{-3, -3, -3, -1}) != -1 {
		t.Fail()
	}
	if singleNumber([]int{3, 3, 3, 1}) != 1 {
		t.FailNow()
	}
	if singleNumber([]int{-3, -3, -3, 1}) != 1 {
		t.FailNow()
	}
}
