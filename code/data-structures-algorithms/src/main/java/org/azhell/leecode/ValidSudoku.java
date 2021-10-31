package org.azhell.leecode;

import org.azhell.tool.StaticData;
import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有效的数独
 * 哈希表数据结构
 * <p>
 * 性能差的一批，但是思想到位了就行了，有时间再优化哈哈
 */
public class ValidSudoku {

    public static void main(String[] args) {
        Utils.print(new ValidSudoku().isValidSudoku(StaticData.board));
        StaticData.board = new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Utils.print(new ValidSudoku().isValidSudoku(StaticData.board));
    }

    public boolean isValidSudoku(char[][] board) {
        // row 、 column、 cube
        Map<String, Set<Character>> map = new HashMap<>(27);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char temp = board[i][j];
                if ('.' == temp) {
                    continue;
                }
                String rowKey = "r" + i;
                Set<Character> characters = map.computeIfAbsent(rowKey, key -> new HashSet<>(9));
                if (characters.contains(temp)) {
                    return false;
                } else {
                    characters.add(temp);
                }
                String columnKey = "c" + j;
                characters = map.computeIfAbsent(columnKey, key -> new HashSet<>(9));
                if (characters.contains(temp)) {
                    return false;
                } else {
                    characters.add(temp);
                }
                String cubeKey = "cu" + i / 3 + j / 3;
                characters = map.computeIfAbsent(cubeKey, key -> new HashSet<>(9));
                if (characters.contains(temp)) {
                    return false;
                } else {
                    characters.add(temp);
                }
            }
        }
        return true;
    }
}
