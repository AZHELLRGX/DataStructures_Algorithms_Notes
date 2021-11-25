package org.azhell.leecode;


import org.azhell.tool.Utils;

/**
 * 79. 单词搜索
 * 尝试回溯法解题  当然还是需要剪枝优化
 * 时间空间占比比较大，但是懒得优化了
 */
public class WordSearch {
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Utils.print(wordSearch.exist(board, "ABCCED"));
        Utils.print(wordSearch.exist(board, "SEE"));
        Utils.print(wordSearch.exist(board, "CCFDA"));
        Utils.print(wordSearch.exist(board, "CEESC"));
        Utils.print(wordSearch.exist(board, "ABCB"));
    }

    // 设置一个哪些格子已经使用过的状态
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        used = new boolean[board.length][board[0].length];
        int x = 0;
        int y = 0;
        // 设置起始点
        while (x < board.length && y < board[0].length) {
            if (exist(board, x, y, new StringBuilder(), word)) {
                return true;
            }
            if (y == board[0].length - 1) {
                x += 1;
                y = 0;
            } else {
                y += 1;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int x, int y, StringBuilder temp, String word) {
        if (temp.toString().equals(word)) {
            return true;
        } else {
            if (0 <= x && 0 <= y && x < board.length && y < board[0].length && !used[x][y]) {
                temp.append(board[x][y]);
                used[x][y] = true;
                if (word.contains(temp)) {
                    // 上下左右找
                    if (exist(board, x + 1, y, temp, word)) {
                        return true;
                    }
                    if (exist(board, x - 1, y, temp, word)) {
                        return true;
                    }
                    if (exist(board, x, y + 1, temp, word)) {
                        return true;
                    }
                    if (exist(board, x, y - 1, temp, word)) {
                        return true;
                    }
                }
                used[x][y] = false;
                temp.deleteCharAt(temp.length() - 1);
            }
            return false;
        }
    }
}
