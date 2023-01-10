package main

import "fmt"

func main() {
	a := []int{1, 2, 3}
	tmp := make([]int, len(a))
	copy(tmp, a)
	fmt.Println(tmp)
}
