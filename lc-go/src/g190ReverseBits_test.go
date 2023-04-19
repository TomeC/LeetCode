package src

import "testing"

func reverseBits(num uint32) uint32 {
	var res uint32 = 0
	for i := 0; i < 32; i++ {
		res |= (num >> i & 1) << (31 - i)
	}
	return res
}

func TestReverseBits(t *testing.T) {
	if reverseBits(43261596) != 964176192 {
		t.FailNow()
	}
}
