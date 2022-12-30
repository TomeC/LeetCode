package src

import (
	"fmt"
	"testing"
)

func solve(board [][]byte) {
	for i := 0; i < len(board); i++ {
		seto(board, i, 0)
		seto(board, i, len(board[0])-1)
	}
	for i := 0; i < len(board[0]); i++ {
		seto(board, 0, i)
		seto(board, len(board)-1, i)
	}
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			if board[i][j] == '#' {
				board[i][j] = 'O'
			} else if board[i][j] == 'O' {
				board[i][j] = 'X'
			}
		}
	}
}
func seto(board [][]byte, row int, col int) {
	if row < 0 || row >= len(board) || col < 0 || col >= len(board[0]) || board[row][col] != 'O' {
		return
	}
	board[row][col] = '#'
	seto(board, row-1, col)
	seto(board, row+1, col)
	seto(board, row, col-1)
	seto(board, row, col+1)
}
func display(board [][]byte) {
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			fmt.Printf("%c ", board[i][j])
		}
		fmt.Println("")
	}
	fmt.Println("")
}
func TestSolve(t *testing.T) {
	board := [][]byte{
		{'X', 'X', 'X', 'X'},
		{'X', 'O', 'O', 'X'},
		{'X', 'X', 'O', 'X'},
		{'X', 'O', 'X', 'X'},
	}
	solve(board)
	display(board)
}
