// https://leetcode.cn/problems/surrounded-regions/description/
#include <vector>
#include <iostream>
using namespace std;

class Solution
{
public:
    void solve(vector<vector<char>> &board)
    {
        for (size_t i = 0; i < board[0].size(); i++)
        {
            seto(board, 0, i);
            seto(board, board.size() - 1, i);
        }
        for (size_t i = 0; i < board.size(); i++)
        {
            seto(board, i, 0);
            seto(board, i, board[0].size() - 1);
        }
        for (size_t i = 0; i < board.size(); i++)
        {
            for (size_t j = 0; j < board[0].size(); j++)
            {
                if (board[i][j] == '#')
                {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
            }
        }
    }
    void seto(vector<vector<char>> &board, int row, int col)
    {
        if (row < 0 || col < 0 || row >= board.size() || col >= board[0].size() || board[row][col] != 'O')
        {
            return;
        }
        board[row][col] = '#';
        seto(board, row - 1, col);
        seto(board, row + 1, col);
        seto(board, row, col - 1);
        seto(board, row, col + 1);
        // 下面是优化的代码，效果变差了
        // if (row - 1 >= 0)
        // {
        //     seto(board, row - 1, col);
        // }
        // if (row + 1 < board.size())
        // {
        //     seto(board, row + 1, col);
        // }
        // if (col - 1 >= 0)
        // {
        //     seto(board, row, col - 1);
        // }
        // if (col + 1 < board[0].size())
        // {
        //     seto(board, row, col + 1);
        // }
    }
    void display(vector<vector<char>> &board)
    {
        for (size_t i = 0; i < board.size(); i++)
        {
            for (size_t j = 0; j < board[0].size(); j++)
            {
                cout << board[i][j] << " ";
            }
            cout << endl;
        }

        cout << endl;
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    vector<vector<char>> v;
    char row1[] = {'X', 'X', 'X', 'X'};
    v.emplace_back(vector<char>(row1, row1 + 4));
    char row2[] = {'X', 'O', 'O', 'X'};
    v.emplace_back(vector<char>(row2, row2 + 4));
    char row3[] = {'X', 'X', 'O', 'X'};
    v.emplace_back(vector<char>(row3, row3 + 4));
    char row4[] = {'X', 'O', 'X', 'X'};
    v.emplace_back(vector<char>(row4, row4 + 4));
    s.solve(v);
    s.display(v);
    return 0;
}
