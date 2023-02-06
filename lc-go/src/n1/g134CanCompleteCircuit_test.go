package next

import "testing"

func canComplete(gas []int, cost []int) int {
	pos := 0
	success := true
	for pos < len(gas) {
		sum := 0
		for i := 0; i < len(gas); i++ {
			tpos := (pos + i) % len(gas)
			sum += (gas[tpos] - cost[tpos])
			if sum < 0 {
				success = false
				pos = pos + i + 1
				break
			}
		}
		if success {
			return pos
		}
		success = true

	}
	if pos >= len(gas) {
		return -1
	}
	return pos
}
func TestCanComplete(t *testing.T) {
	if canComplete([]int{5, 8, 2, 8}, []int{6, 5, 6, 6}) != 3 {
		t.FailNow()
	}
	if canComplete([]int{2, 3, 4}, []int{3, 4, 3}) != -1 {
		t.FailNow()
	}
	if canComplete([]int{1, 2, 3, 4, 5}, []int{3, 4, 5, 1, 2}) != 3 {
		t.FailNow()
	}
	if canComplete([]int{5, 1, 2, 3, 4}, []int{4, 4, 1, 5, 1}) != 4 {
		t.FailNow()
	}
	if canComplete([]int{3, 1, 1}, []int{1, 2, 2}) != 0 {
		t.FailNow()
	}
	if canComplete([]int{11, 4, 7, 1, 0}, []int{2, 5, 5, 9, 1}) != 0 {
		t.FailNow()
	}
}
