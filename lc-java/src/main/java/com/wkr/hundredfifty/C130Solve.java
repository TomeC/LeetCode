package com.wkr.hundredfifty;

/**
 * @Description:
 * @date: 2022/12/28 16:47
 * @author: wangkun
 */
public class C130Solve {
    public static void main(String[] args) {
        C130Solve solve = new C130Solve();
        char [][]board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'}
        };
        solve.solve(board);
        display(board);
    }
    public void solve(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            seto(board, 0,i);
            seto(board, board.length-1,i);
        }
        for (int i = 0; i < board.length; i++) {
            seto(board, i,0);
            seto(board, i,board[0].length-1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void seto(char[][]board, int x, int y) {
        if (x< 0 || y < 0 || x>=board.length || y >= board[0].length || board[x][y] !='O') {
            return;
        }
        board[x][y] = '#';
        seto(board, x-1, y);
        seto(board, x+1, y);
        seto(board, x, y-1);
        seto(board, x, y+1);
    }
    public static void display(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
