package src

import (
	"container/list"
	"strconv"
	"testing"
)

func evalRPN(tokens []string) int {
	stack := list.New()
	for _, s := range tokens {
		if s == "+" {
			a := stack.Remove(stack.Back()).(int)
			b := stack.Remove(stack.Back()).(int)
			stack.PushBack(a + b)
		} else if s == "-" {
			a := stack.Remove(stack.Back()).(int)
			b := stack.Remove(stack.Back()).(int)
			stack.PushBack(b - a)
		} else if s == "*" {
			a := stack.Remove(stack.Back()).(int)
			b := stack.Remove(stack.Back()).(int)
			stack.PushBack(a * b)
		} else if s == "/" {
			a := stack.Remove(stack.Back()).(int)
			b := stack.Remove(stack.Back()).(int)
			stack.PushBack(b / a)
		} else {
			d, _ := strconv.Atoi(s)
			stack.PushBack(d)
		}
	}
	return stack.Back().Value.(int)
}

func TestEvalRPN(t *testing.T) {
	if evalRPN([]string{"2", "1", "+", "3", "*"}) != 9 {
		t.FailNow()
	}
	if evalRPN([]string{"4", "13", "5", "/", "+"}) != 6 {
		t.FailNow()
	}
	if evalRPN([]string{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}) != 22 {
		t.FailNow()
	}
}
