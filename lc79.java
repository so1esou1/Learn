package com.csu.wuyitoyibai;

//力扣79 单词搜索
public class lc79 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            //利用图的深度优先遍历 DFS
            int rows = board.length;
            if (rows == 0) {
                return false;
            }
            int cols = board[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (existRecursive(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean existRecursive(char[][] board, int row, int col, String word, int index) {
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
                return false;
            }
            if (board[row][col] != word.charAt(index)) {
                return false;
            }
            if (index == word.length() - 1) {
                return true;
            }
            /*********************改变的地方****************************************/
            char temp = board[row][col];
            board[row][col] = '$';
            /*********************************************************************/
            boolean up = existRecursive(board, row - 1, col, word, index + 1);
            if (up) {
                return true;
            }
            boolean down = existRecursive(board, row + 1, col, word, index + 1);
            if (down) {
                return true;
            }
            boolean left = existRecursive(board, row, col - 1, word, index + 1);
            if (left) {
                return true;
            }
            boolean right = existRecursive(board, row, col + 1, word, index + 1);
            if (right) {
                return true;
            }
            /*********************改变的地方****************************************/
            board[row][col] = temp;
            /*********************************************************************/
            return false;
        }
    }
}
